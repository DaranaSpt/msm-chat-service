package bo.com.bancofie.msm.chat.mapper;

import bo.com.bancofie.msm.chat.api.Chat;
import bo.com.bancofie.msm.chat.api.Message;
import bo.com.bancofie.msm.chat.entities.ChatMessagesEntity;
import bo.com.bancofie.msm.chat.entities.ChatsEntity;
import bo.com.bancofie.msm.chat.entities.ParticipantsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatsMapper {
    public static Chat participantsEntitiesToChat(ParticipantsEntity entity) {
        Chat chat = new Chat();
        chat.setId(entity.getChat().getId());
        chat.setDateCreated(entity.getDateCreated());
        List<Long> participantsIds = new ArrayList<>();
        entity.getChat().getParticipants()
                .stream().forEach(participant -> {
                    participantsIds.add(participant.getUserId());
                });
        chat.setParticipants(participantsIds);
        return chat;
    }

    public static List<Chat> participantsEntityListToChatList(List<ParticipantsEntity> entityList) {
        return entityList.stream()
                .map(ChatsMapper::participantsEntitiesToChat)
                .collect(Collectors.toList());
    }

    public static Message chatMessageEntityToMessage(ChatMessagesEntity entity) {
        Message message = new Message();
        message.setText(entity.getTextMessage());
        message.setRead(entity.getReadMessage());
        message.setId(entity.getId());
        message.setDateCreated(entity.getDateCreated());
        message.setParticipantId(entity.getParticipantId());
        return message;
    }

    public static List<Message> chatMessageListEntityToMessageList(List<ChatMessagesEntity> entities) {
        return entities.stream()
                .map(ChatsMapper::chatMessageEntityToMessage)
                .collect(Collectors.toList());
    }
}
