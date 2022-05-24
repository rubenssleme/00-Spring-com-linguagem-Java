package avaliacao.base.handlers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class GlobalRestTemplateHandler extends DefaultResponseErrorHandler {

	@Override
	public void handleError(ClientHttpResponse response) {
		String json;
		try {
			json = IOUtils.toString(response.getBody());
			throw new RuntimeException("error in integration: " + json);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}