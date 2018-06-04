package guru.springframework.config;

import guru.springframework.services.GreetingRepository;
import guru.springframework.services.GreetingSerivceFactory;
import guru.springframework.services.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    public GreetingSerivceFactory greetingSerivceFactory(GreetingRepository greetingRepository) {
        return new GreetingSerivceFactory(greetingRepository);
    }

    @Bean
    @Primary
    @Profile("de")
    public GreetingService primaryGermanGreetingService(GreetingSerivceFactory greetingSerivceFactory) {
        return greetingSerivceFactory.createGreetingService("de");
    }

    @Bean
    @Primary
    @Profile("es")
    public GreetingService primarySpanishGreetingService(GreetingSerivceFactory greetingSerivceFactory) {
        return greetingSerivceFactory.createGreetingService("es");
    }

    @Bean
    @Primary
    @Profile({"en", "default"})
    public GreetingService primaryGreetingService(GreetingSerivceFactory greetingSerivceFactory) {
        return greetingSerivceFactory.createGreetingService("en");
    }
}
