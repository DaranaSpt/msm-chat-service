package bo.com.bancofie.msm.chat.controller;

import bo.com.bancofie.msm.chat.api.*;
import bo.com.bancofie.msm.chat.dao.BaseResponse;
import bo.com.bancofie.msm.chat.handler.MagentaException;
import bo.com.bancofie.msm.chat.services.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/chats")
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private ChatService chatService;

    @PostMapping("/createChat")
    public ResponseEntity<BaseResponse<CreateChatResponse>> createChat(@RequestHeader HttpHeaders header, @RequestBody @Valid CreateChatRequest request) throws MagentaException {
        logger.info("Calling createChat...");
        return new ResponseEntity<>(chatService.createChat(header, request), HttpStatus.OK);
    }

    @PostMapping("/getChats")
    public ResponseEntity<BaseResponse<GetChatsResponse>> getChats(@RequestHeader HttpHeaders header, @RequestBody @Valid GetChatsRequest request) throws MagentaException {
        logger.info("Calling getChats...");
        return new ResponseEntity<>(chatService.getChats(header, request), HttpStatus.OK);
    }

    @PostMapping("/createMessage")
    public ResponseEntity<BaseResponse<CreateMessageResponse>> createMessage(@RequestHeader HttpHeaders header, @RequestBody @Valid CreateMessageRequest request) throws MagentaException {
        logger.info("Calling createMessage...");
        return new ResponseEntity<>(chatService.createMessage(header, request), HttpStatus.OK);
    }

    @PostMapping("/getMessages")
    public ResponseEntity<BaseResponse<GetMessagesResponse>> getMessages(@RequestHeader HttpHeaders header, @RequestBody @Valid GetMessagesRequest request) throws MagentaException {
        logger.info("Calling getMessages...");
        return new ResponseEntity<>(chatService.getMessages(header, request), HttpStatus.OK);
    }

    @PostMapping("/readMessage")
    public ResponseEntity<BaseResponse<ReadMessageResponse>> readMessage(@RequestHeader HttpHeaders header, @RequestBody @Valid ReadMessageRequest request) throws MagentaException {
        logger.info("Calling readMessage...");
        return new ResponseEntity<>(chatService.readMessage(header, request), HttpStatus.OK);
    }

    @PostMapping("/deleteChat")
    public ResponseEntity<BaseResponse<DeleteChatResponse>> deleteChat(@RequestHeader HttpHeaders header, @RequestBody @Valid DeleteChatRequest request) throws MagentaException {
        logger.info("Calling deleteChat...");
        return new ResponseEntity<>(chatService.deleteChat(header, request), HttpStatus.OK);
    }
}
