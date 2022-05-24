package avaliacao.hackathon.repository;

import avaliacao.hackathon.model.entities.EvaluatorBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluatorBlockRepository extends JpaRepository<EvaluatorBlock, Long> {
}
