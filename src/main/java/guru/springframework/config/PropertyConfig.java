package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {
    @Autowired
    private Environment environment;

    @Value("${guru.username}")
    private String userName;
    @Value("${guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String dbUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        // fakeDataSource.setUsername(userName);
        /*
        I have created a system environment property with the name username
        Go to the run configuration "DiDemoApplication"
        Under the Environment -> Environment variable add a new variable an give it a value

        Or
        you cane just override the guru.username in the Environment variable
        by adding GURU_USERNAME (low case works too but with dot didnot work) and give it a value
         */
        fakeDataSource.setUsername(environment.getProperty("username"));

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
