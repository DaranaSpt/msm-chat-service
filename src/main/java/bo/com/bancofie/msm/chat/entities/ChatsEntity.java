package bo.com.bancofie.msm.chat.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chats")
public class ChatsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_deleted")
    private LocalDateTime dateDeleted;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ParticipantsEntity> participants;
}
