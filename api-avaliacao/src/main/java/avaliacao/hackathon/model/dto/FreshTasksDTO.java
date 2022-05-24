package avaliacao.hackathon.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreshTasksDTO {

    private String login;

    private Long idTimesheetTask;

    private LocalDate taskDate;

    private String costCenterId;

    private String costCenterDescription;

    private Long taskType;

    private Boolean differentiatedRegime;

    private Boolean contested;

    private String optionalCode;

    private String description;

    private Double minutes;

    private Long originApplication;

    private String createdBy;

    private LocalDateTime createdAt;

    private String modifiedBy;

    private LocalDateTime modifiedAt;
}
