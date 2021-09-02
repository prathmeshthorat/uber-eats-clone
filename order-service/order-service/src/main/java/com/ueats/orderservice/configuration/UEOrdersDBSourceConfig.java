package com.ueats.orderservice.configuration;

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
@EnableJpaRepositories(entityManagerFactoryRef = "orderEntityManagerFactory", basePackages = {"com.ueats.orderservice.repository"},
transactionManagerRef = "orderTransactionManager")
public class UEOrdersDBSourceConfig {
	
	
	@Bean(name = "orderDataSource")
	@ConfigurationProperties(prefix = "spring.orders.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/uber_eats_order").build();
	}

	@Bean(name = "orderEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("orderDataSource") DataSource orderDataSource) {

		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return builder.dataSource(orderDataSource).packages("com.ueats.orderservice.entity").properties(properties)
				.persistenceUnit("Order").build();
	}

	@Bean(name = "orderTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("orderEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
