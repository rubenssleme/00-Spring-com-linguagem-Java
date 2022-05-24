package avaliacao.base.utils;

import com.azure.spring.aad.webapi.AADOAuth2AuthenticatedPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthUtil {

    private final OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

    public OAuth2AuthorizedClient getAuthorizedClient() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        return oAuth2AuthorizedClientRepository.loadAuthorizedClient("api", principal, sra.getRequest());
    }

    public OAuth2AuthorizedClient getAuthorizedClientGraph() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        return oAuth2AuthorizedClientRepository.loadAuthorizedClient("graph", principal, sra.getRequest());
    }

    public String getAuthenticatedUserLogin() {
        AADOAuth2AuthenticatedPrincipal authentication =
            (AADOAuth2AuthenticatedPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (String) authentication.getAttributes().get("unique_name");
    }

    public Map<String, Object> getAuthenticatedUserAtributes(){
        AADOAuth2AuthenticatedPrincipal authetication =
            (AADOAuth2AuthenticatedPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  authetication.getAttributes();
    }
}
