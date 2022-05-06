package br.com.timtec;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.timtec.model.Hotel;


@Configuration
public class CustomConfigRest extends RepositoryRestConfigurerAdapter{
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Hotel.class);
	}

}
