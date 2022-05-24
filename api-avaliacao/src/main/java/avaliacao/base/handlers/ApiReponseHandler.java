package avaliacao.base.handlers;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import avaliacao.base.exceptions.AppErrors;
import avaliacao.base.localization.IMessageSource;
import avaliacao.base.utils.DResponse;
import lombok.RequiredArgsConstructor;

@ControllerAdvice(value = {"avaliacao"})
@Order(2)
@RequiredArgsConstructor
public class ApiReponseHandler implements ResponseBodyAdvice<Object> {
    private final IMessageSource messageSource;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getParameterType().equals(ResponseEntity.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class converterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        String message = messageSource.getMessage(AppErrors.SUCCESS);

        return DResponse.ok(body, AppErrors.SUCCESS.getCode(), message);
    }
}
