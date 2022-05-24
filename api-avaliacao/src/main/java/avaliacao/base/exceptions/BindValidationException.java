package avaliacao.base.exceptions;

import org.springframework.validation.Errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BindValidationException extends BaseException {

	private static final long serialVersionUID = -3447828144963305853L;

	@Getter
    private final Errors bindErrors;

    @Override
    public AppErrors error() {
        return AppErrors.BINDING_VALIDATION_ERROR;
    }
}
