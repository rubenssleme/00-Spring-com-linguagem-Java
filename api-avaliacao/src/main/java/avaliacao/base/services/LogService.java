package avaliacao.base.services;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogService {
    private static final String USER = "user";
    private static final String IP = "src_ip";
    private static final String ACTIVITY = "activity";
    private static final String ACTION = "action";
    private static final String APPLOG = "applog";
    private static final String SAVE_TO_FILE = "save_to_file";

    private static final String APP_LOG = "true";
    private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Client-Ip", "Proxy-Client-IP", "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };


    public void build(HttpServletRequest request) {
        ThreadContext.put(USER, getUser(request));
        ThreadContext.put(IP, getRemoteAddress(request));
        ThreadContext.put(ACTIVITY, request.getRequestURI());
        ThreadContext.put(ACTION, request.getMethod());
        ThreadContext.put(APPLOG, APP_LOG);
        ThreadContext.put(SAVE_TO_FILE, "true");
    }

    public void clear() {
        ThreadContext.clearAll();
    }

    public static String getUser(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }

        return request.getRemoteAddr();
    }

    public static String getRemoteAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }

        return request.getRemoteAddr();
    }
}
