package avaliacao.hackathon.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Evaluator extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluatorId")
    private Long Id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluator", cascade = CascadeType.ALL)
    Set<EvaluatorBlock> blocks;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluator", cascade = CascadeType.ALL)
    Set<Conflict> conflits;

    private String type;

    private String acronym;
}
