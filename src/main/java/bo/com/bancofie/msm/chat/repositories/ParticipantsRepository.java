package bo.com.bancofie.msm.chat.repositories;

import bo.com.bancofie.msm.chat.entities.ParticipantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParticipantsRepository extends JpaRepository<ParticipantsEntity, Long> {
    List<ParticipantsEntity> findByUserId(Long userId);
}
