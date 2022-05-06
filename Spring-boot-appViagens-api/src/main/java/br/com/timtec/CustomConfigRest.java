package br.com.timtec;

import org.springframework.context.annotation.Configuration;


import br.com.timtec.model.Hotel;


@Configuration
public class CustomConfigRest extends RepositoryRestConfigurerAdapter{
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Hotel.class);
	}

}
