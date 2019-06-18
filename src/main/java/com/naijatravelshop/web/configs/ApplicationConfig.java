package com.naijatravelshop.web.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.security.SecureRandom;

/**
 * Created by jnwanya on
 * Wed, 27 Mar, 2019
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        String SALT = "fhsjdhk12h90873kkslkdsndwe"; //The encryption salt
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    /* FOR INTERNATIONALIZATION */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:i18n/messages");
        resourceBundleMessageSource.setCacheSeconds(1800);
        return resourceBundleMessageSource;
    }

}
