package avaliacao.base.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import avaliacao.base.services.LogService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogHandlerInterceptor extends HandlerInterceptorAdapter {
    private final LogService logService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logService.clear();
    }
}
