package bo.com.bancofie.msm.chat.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_messages")
public class ChatMessagesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "text_message")
    private String textMessage;

    @Column(name = "read_message")
    private Boolean readMessage;

    @Column(name = "date_deleted")
    private LocalDateTime dateDeleted;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}
