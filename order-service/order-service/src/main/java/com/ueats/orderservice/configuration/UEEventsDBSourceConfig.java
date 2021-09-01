package com.ueats.orderservice.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {"com.ueats.orderservice.events.repository"})
public class UEEventsDBSourceConfig {
	
	@Primary
	@Bean(name = "eventsDataSource")
	@ConfigurationProperties(prefix = "spring.events.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("eventsDataSource") DataSource  eventsDataSource) {
		return builder.dataSource(eventsDataSource).packages("com.ueats.orderservice.entity").persistenceUnit("")
	}
}
