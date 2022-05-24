package avaliacao.hackathon.model.keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ConfidantKey implements Serializable {

    @Column(name = "evaluator_id")
    private Long evaluatorId;

    @Column(name = "participant_id")
    private Long participantId;
}
