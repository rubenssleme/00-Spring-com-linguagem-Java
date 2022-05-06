package br.com.fernando.api.k2partnering.resources.exceptions;

import br.com.fernando.api.k2partnering.service.exception.AuthorizationException;
import br.com.fernando.api.k2partnering.service.exception.DataIntegrityExecpition;
import br.com.fernando.api.k2partnering.service.exception.ObjectNotFoundExecpition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExeceptionHandler {

    @ExceptionHandler(ObjectNotFoundExecpition.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExecpition e, HttpServletRequest request) {
        StandardError err = new StandardError (System.currentTimeMillis (), HttpStatus.NOT_FOUND.value (),
                "Não encontrado", e.getMessage (), request.getRequestURI ());
        return ResponseEntity.status (HttpStatus.NOT_FOUND).body (err);
    }

    @ExceptionHandler(DataIntegrityExecpition.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityExecpition e, HttpServletRequest request) {
        StandardError err = new StandardError (System.currentTimeMillis (), HttpStatus.BAD_REQUEST.value (),
                "Integridade de dados", e.getMessage (), request.getRequestURI ());
        return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (err);
    }
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
        StandardError err = new StandardError(System.currentTimeMillis(),
                HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }
}
