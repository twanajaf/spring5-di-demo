package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {
    @Value("${guru.username}")
    private String userName;
    @Value("${guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String dbUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(dbUrl);

        return fakeDataSource;
    }

    //Loading the properties does not need manual PropertySourcesPlaceholderConfigurer creation
    // Because spring boot will create this bean through PropertyPlaceholderAutoConfiguration
/*    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
