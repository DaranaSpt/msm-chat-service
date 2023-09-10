package bo.com.bancofie.msm.chat.services;

import bo.com.bancofie.msm.chat.api.*;
import bo.com.bancofie.msm.chat.dao.BaseResponse;
import bo.com.bancofie.msm.chat.dao.Header;
import bo.com.bancofie.msm.chat.handler.MagentaException;
import org.springframework.http.HttpHeaders;

public interface ChatService {
    BaseResponse<CreateChatResponse> createChat(HttpHeaders header, CreateChatRequest request) throws MagentaException;
    BaseResponse<GetChatsResponse> getChats(HttpHeaders header, GetChatsRequest request) throws MagentaException;
    BaseResponse<CreateMessageResponse> createMessage(HttpHeaders header, CreateMessageRequest request) throws MagentaException;
    BaseResponse<GetMessagesResponse> getMessages(HttpHeaders header, GetMessagesRequest request) throws MagentaException;
    BaseResponse<ReadMessageResponse> readMessage(HttpHeaders header, ReadMessageRequest request) throws MagentaException;
    BaseResponse<DeleteChatResponse> deleteChat(HttpHeaders header, DeleteChatRequest request) throws MagentaException;
}
