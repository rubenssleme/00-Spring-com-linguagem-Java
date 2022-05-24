package avaliacao.hackathon.model.keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class EvaluatorBlockKey implements Serializable {

    @Column(name = "evaluator_id")
    private Long evaluatorId;

    @Column(name = "block_id")
    private Long blockId;
}