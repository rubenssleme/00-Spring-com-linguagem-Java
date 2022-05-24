package avaliacao.base.exceptions;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = -7616433579514158864L;

	public BaseException() {}

    public BaseException(Throwable ex) {
        super(ex);
    }

    public abstract AppErrors error();
}
