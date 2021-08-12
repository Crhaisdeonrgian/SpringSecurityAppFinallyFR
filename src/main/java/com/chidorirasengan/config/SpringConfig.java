package com.chidorirasengan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;


/**
 * Creates resolver instance w/ preset prefix and suffix
 * Currently it resolves jsp files from views directory
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 * @version 10000.0))
 */
@Configuration
@ComponentScan("com.chidorirasengan")
@EnableWebMvc
public class SpringConfig {
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());

    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/template_db");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        return driverManagerDataSource;
    }
    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}