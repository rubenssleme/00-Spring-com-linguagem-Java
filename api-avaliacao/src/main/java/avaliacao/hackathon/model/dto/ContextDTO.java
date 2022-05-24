package avaliacao.hackathon.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ContextDTO {

    private Long Id;

    private String name;

    private LocalDateTime startDay;

    private LocalDateTime endDay;

    private String status;

//    private LocalDateTime createdAt;
//
//    private String createdBy;
//
//    private LocalDateTime modifiedAt;
//
//    private String modifiedBy;
}
