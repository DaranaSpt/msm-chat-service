package bo.com.bancofie.msm.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Configuration class for creating a customized RestTemplate bean.
 */
@Configuration
public class TemplateConfig {

    @Value("${keycloak.url}") // Obtain the base URL from your application properties (application.properties)
    private String baseUrl;

    /**
     * Creates and configures a RestTemplate bean with a custom base URL.
     *
     * @return RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Configure the base URL
        restTemplate.setUriTemplateHandler(getUriTemplateHandler());

        return restTemplate;
    }

    /**
     * Creates a DefaultUriBuilderFactory with the provided base URL.
     *
     * @return DefaultUriBuilderFactory instance
     */
    private DefaultUriBuilderFactory getUriTemplateHandler() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        return factory;
    }
    
}
