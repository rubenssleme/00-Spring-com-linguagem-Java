package avaliacao.base.exceptions;

public class UnexpectedException extends RuntimeException {
	private static final long serialVersionUID = -899187470501050388L;

	public UnexpectedException(String message) {
		super(message);
	}
}
