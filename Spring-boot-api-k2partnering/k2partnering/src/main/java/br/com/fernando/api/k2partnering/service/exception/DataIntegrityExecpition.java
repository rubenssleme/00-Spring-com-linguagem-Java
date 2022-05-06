package br.com.fernando.api.k2partnering.service.exception;

public class DataIntegrityExecpition  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataIntegrityExecpition(String msg) {
        super(msg);
    }
    public DataIntegrityExecpition (String msg, Throwable cause) {
        super(msg,cause);
    }
}
