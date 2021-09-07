package com.ueats.paymentservice.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.ueats.paymentservice.events.repository" }, entityManagerFactoryRef = "eventsEntityManagerFactory", transactionManagerRef = "eventsTransactionManager")
public class UEEventsDBSourceConfig {

	@Bean(name = "eventsDataSource")
	@ConfigurationProperties(prefix = "spring.events.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/uber_eats_events").build();
	}

	@Bean(name = "eventsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder emFactoryBuilder,
			@Qualifier("eventsDataSource") DataSource dataSource) {

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return emFactoryBuilder.dataSource(dataSource).packages("com.ueats.paymentservice.events.entity")
				.properties(properties).persistenceUnit("event").build();
	}

	@Bean(name = "eventsTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("eventsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
