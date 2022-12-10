package dev.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "dev.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

    //Will hold the values of properties file
    private Environment env;

    //Logger is for debugging purposes
    private final Logger logger = Logger.getLogger(getClass().getName());

    // define a bean for resolving views

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource setDataSource() {

        //create connection pool
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //set the jdbc driver class
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection props
        logger.info(String.format("url: %s", env.getProperty("jdbc.url")));
        logger.info(String.format("user %s", env.getProperty("jdbc.user")));

        //set database connection props
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        //set connection pools
        dataSource.setInitialPoolSize(getIntegerValuedProps(env.getProperty("connection.pool.initialPoolSize")));
        dataSource.setMinPoolSize(getIntegerValuedProps(env.getProperty("connection.pool.minPoolSize")));
        dataSource.setMaxPoolSize(getIntegerValuedProps(env.getProperty("connection.pool.maxPoolSize")));
        dataSource.setMaxIdleTime(getIntegerValuedProps(env.getProperty("connection.pool.maxIdleTime")));

        return dataSource;
    }

    private int getIntegerValuedProps(String propName) {
        String propString = env.getProperty(propName);
        return Integer.parseInt(Objects.requireNonNull(propString));
    }
}
