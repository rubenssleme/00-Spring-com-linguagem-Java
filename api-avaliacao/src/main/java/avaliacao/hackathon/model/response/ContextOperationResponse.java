package avaliacao.hackathon.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContextOperationResponse {

    private Boolean operationSuccess;

    private String errorMessage;
}
