package config;

import dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Map;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    @Value("${dao.target:dao}") // "dao" est la valeur par défaut si absent du fichier
    private String target;

    @Bean(name = "dao")
    public IDao selectedDao(Map<String, IDao> candidates) {

        IDao bean = candidates.get(target);

        if (bean == null) {
            throw new IllegalArgumentException("Erreur OCP : L'implémentation '" + target +
                    "' est introuvable. Vérifiez vos annotations @Component(\"name\").");
        }

        return bean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

