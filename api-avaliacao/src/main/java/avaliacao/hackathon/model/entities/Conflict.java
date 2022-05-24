package avaliacao.hackathon.model.entities;

import avaliacao.hackathon.model.keys.ConfidantKey;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conflict extends BaseEntity {

    @EmbeddedId
    @Column(name = "conflit_Key")
    private ConfidantKey confiltKey;

    @ManyToOne
    @MapsId("participant_id")
    @JoinColumn(name = "participant_id")
    Participant participant;

    @ManyToOne
    @MapsId("evaluator_id")
    @JoinColumn(name = "evaluator_id")
    Evaluator evaluator;
}
