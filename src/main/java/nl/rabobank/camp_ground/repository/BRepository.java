package nl.rabobank.camp_ground.repository;

import nl.rabobank.camp_ground.entity.camp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BRepository extends JpaRepository<camp, UUID> {
}
