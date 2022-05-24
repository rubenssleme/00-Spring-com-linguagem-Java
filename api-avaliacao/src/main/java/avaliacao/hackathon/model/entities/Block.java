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
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blockId")
    private Long Id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contestId")
    private Context contest;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "block", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "block", cascade = CascadeType.ALL)
    Set<EvaluatorBlock> blocks;
}
