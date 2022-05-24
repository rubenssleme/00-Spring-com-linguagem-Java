package avaliacao.hackathon.repository;

import avaliacao.hackathon.model.entities.Evaluator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvaluatorRepository extends JpaRepository<Evaluator, Long> {
}
