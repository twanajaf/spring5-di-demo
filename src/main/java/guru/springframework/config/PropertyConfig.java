package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
// OR
/*
@PropertySources({

                         @PropertySource("classpath:datasource.properties"),
                         @PropertySource("classpath:jms.properties")
                 })
                  */
public class PropertyConfig {

    @Value("${guru.username}")
    private String userName;
    @Value("${guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String dbUrl;

    @Value("${guru.jms.username}")
    private String jmsUserName;
    @Value("${guru.jms.password}")
    private String jmsPassword;
    @Value("${guru.jms.dburl}")
    private String jmsDbUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(dbUrl);

        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(jmsUserName);

        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsDbUrl);

        return fakeJmsBroker;
    }

    //Loading the properties does not need manual PropertySourcesPlaceholderConfigurer creation
    // Because spring boot will create this bean through PropertyPlaceholderAutoConfiguration
/*    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
