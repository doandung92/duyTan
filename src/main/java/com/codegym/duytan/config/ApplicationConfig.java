package com.codegym.duytan.config;

import com.codegym.duytan.listener.AuditorAwareImpl;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,
        basePackages = "com.codegym.duytan.repository")
public class ApplicationConfig implements WebMvcConfigurer {

    @Bean
    MapperFacade mapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .mapNulls(false)
                .useBuiltinConverters(false).build();
        return mapperFactory.getMapperFacade();
    }

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login-google");
    }
}
