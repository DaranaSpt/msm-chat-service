package bo.com.bancofie.msm.chat.repositories;

import bo.com.bancofie.msm.chat.entities.ChatMessagesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessagesEntity, Long> {
    Page<ChatMessagesEntity> findByChatId(Long userId, Pageable pageable);
}
