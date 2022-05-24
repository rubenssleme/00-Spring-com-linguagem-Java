package avaliacao.hackathon.integration;

import com.microsoft.applicationinsights.core.dependencies.http.client.utils.URIBuilder;
import avaliacao.hackathon.model.dto.FreshTasksDTO;
import avaliacao.base.utils.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.naming.ServiceUnavailableException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@Component
@RequiredArgsConstructor
public class FreshServiceClient {

    private final WebClient webClient;

    private final AuthUtil authUtil;

    @Value("${fresh.source.url}")
    private String freshServiceBaseUrl;

    public List<FreshTasksDTO> getFreshTasksByDateBetween(String login, List<LocalDate> dates) throws ServiceUnavailableException {
        return Arrays.asList(Objects.requireNonNull(
            webClient
                .get()
                .uri(buildUrl(null, Collections.singletonList(login), dates))
                .attributes(oauth2AuthorizedClient(authUtil.getAuthorizedClient()))
                .retrieve()
                .bodyToMono(FreshTasksDTO[].class)
                .block()));
    }

    public String buildUrl(List<String> costCenters, List<String> login, List<LocalDate> date) {
        URIBuilder builder = new URIBuilder()
            .setHost(freshServiceBaseUrl)
            .setPath("/api/tasks");

        addParams(builder, costCenters, login, date);

        return builder.toString().substring(2);
    }

    private void addParams(URIBuilder builder, List<String> costCenters, List<String> logins, List<LocalDate> dates) {
        if (Objects.nonNull(costCenters) && !costCenters.isEmpty()) {
            for (String costCenter : costCenters) {
                builder.addParameter("costCenter", costCenter);
            }
        }

        if (Objects.nonNull(logins) && !logins.isEmpty()) {
            for (String login : logins) {
                builder.addParameter("login", login);
            }
        }

        if (Objects.nonNull(dates) && !dates.isEmpty()) {
            for (LocalDate date : dates) {
                builder.addParameter("date", date.toString());
            }
        }
    }
}
