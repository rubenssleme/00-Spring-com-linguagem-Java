package avaliacao.hackathon.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Evaluation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluationId")
    private Long Id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scoreId")
    private Score score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "block_id", insertable = false, updatable = false),
        @JoinColumn(name = "evaluator_id", insertable = false, updatable = false)
    })
    private EvaluatorBlock evaluatorBlock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participantId")
    private Participant participant;

}
