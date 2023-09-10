package bo.com.bancofie.msm.chat.repositories;

import bo.com.bancofie.msm.chat.entities.ChatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatsEntity, Long> {
}
