package avaliacao.hackathon.repository;

import avaliacao.hackathon.model.dto.ContextDTO;
import avaliacao.hackathon.model.entities.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextRepository extends JpaRepository<Context, Long> {

    @Query("SELECT new iteris.hackathon.model.dto.ContextDTO(c.id, c.name, c.startDay, c.endDay, c.status)" +
        "FROM Context c ORDER BY c.name")
    List<ContextDTO> getAllContexts();

}
