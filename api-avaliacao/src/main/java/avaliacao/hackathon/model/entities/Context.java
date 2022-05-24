package avaliacao.hackathon.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Context extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contestId")
    private Long Id;

    private String name;

    private LocalDateTime startDay;

    private LocalDateTime endDay;

    private String status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contest", cascade = CascadeType.ALL)
    private List<Block> blocks;
}
