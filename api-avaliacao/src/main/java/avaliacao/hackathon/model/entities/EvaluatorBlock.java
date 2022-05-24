package avaliacao.hackathon.model.entities;


import avaliacao.hackathon.model.keys.EvaluatorBlockKey;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Data
@SuperBuilder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluatorBlock extends BaseEntity{

    @EmbeddedId
    @Column(name = "evaluatorBlockId")
    private EvaluatorBlockKey evaluatorBlockId;

    @ManyToOne
    @MapsId("block_id")
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne
    @MapsId("evaluator_id")
    @JoinColumn(name = "evaluator_id")
    private Evaluator evaluator;

}
