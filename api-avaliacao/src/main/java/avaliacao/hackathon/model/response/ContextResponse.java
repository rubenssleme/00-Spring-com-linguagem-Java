package avaliacao.hackathon.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContextResponse {

    private Long Id;

    private String name;

    private String startDay;

    private String endDay;

    private String status;
}
