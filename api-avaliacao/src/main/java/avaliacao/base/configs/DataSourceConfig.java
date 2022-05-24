package avaliacao.base.configs;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import avaliacao.base.utils.EncryptAndDecryptString;

@Configuration
public class DataSourceConfig {

    @Value("${crypto.url}")
    private String url;

    @Value("${crypto.username}")
    private String username;

    @Value("${crypto.password}")
    private String password;

    @Value("${crypto.driverClassName}")
    private String driverClassName;

    @Value("${secret.key}")
    private String secretKey;

    @Bean
    public DataSource getDataSource() throws GeneralSecurityException, UnsupportedEncodingException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(EncryptAndDecryptString.decrypt(secretKey, url));
        dataSourceBuilder.username(EncryptAndDecryptString.decrypt(secretKey, username));
        dataSourceBuilder.password(EncryptAndDecryptString.decrypt(secretKey, password));
        dataSourceBuilder.driverClassName(EncryptAndDecryptString.decrypt(secretKey, driverClassName));

        return dataSourceBuilder.build();
    }
}