package bo.com.bancofie.msm.chat.services;


import bo.com.bancofie.msm.chat.api.*;
import bo.com.bancofie.msm.chat.dao.BaseResponse;
import bo.com.bancofie.msm.chat.dao.Header;
import bo.com.bancofie.msm.chat.entities.ChatMessagesEntity;
import bo.com.bancofie.msm.chat.entities.ChatsEntity;
import bo.com.bancofie.msm.chat.entities.ParticipantsEntity;
import bo.com.bancofie.msm.chat.handler.MagentaException;
import bo.com.bancofie.msm.chat.mapper.ChatsMapper;
import bo.com.bancofie.msm.chat.repositories.ChatMessageRepository;
import bo.com.bancofie.msm.chat.repositories.ChatRepository;
import bo.com.bancofie.msm.chat.repositories.ParticipantsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChatServiceImp implements ChatService {
  @Autowired
  private ChatRepository chatRepository;
  @Autowired
  private ParticipantsRepository participantsRepository;
  @Autowired
  private ChatMessageRepository chatMessageRepository;
  private static final Logger logger = LoggerFactory.getLogger(ChatServiceImp.class);

  @Override
  public BaseResponse<CreateChatResponse> createChat(HttpHeaders header, CreateChatRequest request) throws MagentaException {
    try {
      String myUserId = header.get("userId").get(0);
      request.getParticipants().add(Long.parseLong(myUserId));
      ChatsEntity chat = new ChatsEntity();
      chat.setDateCreated(LocalDateTime.now());
      chat = chatRepository.save(chat);
      CreateChatResponse response = new CreateChatResponse()
              .setId(chat.getId())
              .setDateCreated(chat.getDateCreated());
      ParticipantsEntity participant;
      for (Long userId : request.getParticipants()) {
        participant = new ParticipantsEntity();
        participant.setUserId(userId);
        participant.setChat(chat);
        participant.setDateCreated(LocalDateTime.now());
        participantsRepository.save(participant);
      }
      response.setParticipants(request.getParticipants());
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al crear el chat");
    }
  }

  @Override
  public BaseResponse<GetChatsResponse> getChats(HttpHeaders header, GetChatsRequest request) throws MagentaException {
    try {
      GetChatsResponse response = new GetChatsResponse();
      List<ParticipantsEntity> participantsEntities = participantsRepository.findByUserId(Long.parseLong(header.get("userId").get(0)));
      if (request.getId() != 0) {
        participantsEntities = participantsEntities.stream()
                .filter(participant -> Objects.equals(participant.getChat().getId(), request.getId()))
                .collect(Collectors.toList());
      }
      participantsEntities = participantsEntities.stream()
              .filter(participant -> participant.getChat().getDateDeleted() == null)
              .collect(Collectors.toList());
      response.setItems(ChatsMapper.participantsEntityListToChatList(participantsEntities));
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al obtener chats");
    }
  }

  @Override
  public BaseResponse<CreateMessageResponse> createMessage(HttpHeaders header, CreateMessageRequest request) throws MagentaException {
    try {
      CreateMessageResponse response = new CreateMessageResponse();
      Optional<ChatsEntity> chatsEntity = chatRepository.findById(request.getChatId());
      if(!chatsEntity.isPresent()) {
        throw new MagentaException("El chat no existe");
      }
      ParticipantsEntity participantsEntity = chatsEntity.get().getParticipants()
              .stream().filter(p -> p.getUserId().equals(Long.parseLong(header.get("userId").get(0))))
              .findFirst().orElse(null);
      ChatMessagesEntity messagesEntity = new ChatMessagesEntity();
      messagesEntity.setDateCreated(LocalDateTime.now());
      messagesEntity.setTextMessage(request.getText());
      messagesEntity.setReadMessage(false);
      messagesEntity.setParticipantId(participantsEntity.getId());
      messagesEntity.setChatId(request.getChatId());
      messagesEntity = chatMessageRepository.save(messagesEntity);
      response.setChatId(request.getChatId());
      response.setId(messagesEntity.getId());
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al registrar mensaje");
    }
  }

  @Override
  public BaseResponse<GetMessagesResponse> getMessages(HttpHeaders header, GetMessagesRequest request) throws MagentaException {
    try {
      GetMessagesResponse response = new GetMessagesResponse();
      Optional<ChatsEntity> chatsEntities = chatRepository.findById(request.getChatId());
      if (!chatsEntities.isPresent()) {
        throw new MagentaException("No existe el chat asociado");
      }
      Pageable pageable = PageRequest.of(request.getPage().intValue() - 1, 20);
      Page<ChatMessagesEntity> page = chatMessageRepository.findByChatId(request.getChatId(), pageable);
      List<ChatMessagesEntity> messages = page.getContent();
      response.setPage(request.getPage());
      response.setItems(ChatsMapper.chatMessageListEntityToMessageList(messages));
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al obtener mensajes");
    }
  }

  @Override
  public BaseResponse<ReadMessageResponse> readMessage(HttpHeaders header, ReadMessageRequest request) throws MagentaException {
    try {
      ReadMessageResponse response = new ReadMessageResponse();
      Optional<ChatMessagesEntity> chatMessagesEntity = chatMessageRepository.findById(request.getMessageId());
      if (!chatMessagesEntity.isPresent()) {
        throw new MagentaException("El mensaje no existe");
      }
      chatMessagesEntity.get().setReadMessage(true);
      chatMessageRepository.save(chatMessagesEntity.get());
      response.setId(chatMessagesEntity.get().getId());
      response.setRead(chatMessagesEntity.get().getReadMessage());
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al marcar mensaje como leido");
    }
  }

  @Override
  public BaseResponse<DeleteChatResponse> deleteChat(HttpHeaders header, DeleteChatRequest request) throws MagentaException {
    try {
      DeleteChatResponse response = new DeleteChatResponse();
      Optional<ChatsEntity> chatsEntity = chatRepository.findById(request.getId());
      if (!chatsEntity.isPresent()) {
        throw new MagentaException("El chat no existe");
      }
      chatsEntity.get().setDateDeleted(LocalDateTime.now());
      chatRepository.save(chatsEntity.get());
      response.setId(request.getId());
      response.setStatus("DELETED");
      return new BaseResponse<>(response);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new MagentaException("Error al borrar chat");
    }
  }
}
