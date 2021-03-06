package avaliacao.base.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AppException extends BaseException {

	private static final long serialVersionUID = -4349161679424677660L;
	private final AppErrors errorType;

    private AppException(AppErrors errorType, Throwable ex) {
        super(ex);
        this.errorType = errorType;
    }

    @Override
    public AppErrors error() {
        return errorType;
    }

    public static AppException of(AppErrors errorType) {
        return new AppException(errorType);
    }

    public static AppException of(AppErrors errorType, Throwable ex) {
        return new AppException(errorType, ex);
    }
}
