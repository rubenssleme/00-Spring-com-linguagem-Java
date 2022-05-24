package avaliacao.hackathon.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participantId")
    private Long Id;

    private String name;

    private String email;

    private String picture;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "participant", cascade = CascadeType.ALL)
    Set<Conflict> conflicts;

    private String status;
}
