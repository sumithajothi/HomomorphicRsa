/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Postgres Sql Configuration where the Database Resides on the cloud
 */
@Configuration
@PropertySources({ @PropertySource("classpath:datasource.properties"),
		@PropertySource("classpath:application.properties") })
@PropertySource("classpath:datasource.properties")
@EnableJpaRepositories(basePackages = { "com.test.algorithm.runner" }, entityManagerFactoryRef = "emf")
@EnableTransactionManagement
@EnableSpringDataWebSupport
@ComponentScan(basePackages = { "com.test.algorithm.runner" })
public class PostgresJpaConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(PostgresJpaConfiguration.class);
	@Autowired
	private Environment environment;

	/**
	 * Builds and Returns the data source bean. The values are fetched from
	 * properties file
	 */
	@Bean
	public DataSource dataSource() {
		logger.info("Setting Data Source to MySql..");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		String connectionString = "jdbc:postgresql://" + environment.getProperty("spring.datasource.postgres.host")
				+ ":" + environment.getProperty("spring.datasource.postgres.port") + "/"
				+ environment.getProperty("spring.datasource.postgres.dbName");
		dataSource.setUrl(connectionString);
		return dataSource;
	}

	/**
	 * Returns the entity manager bean
	 */
	@Bean
	public EntityManager entityManager() {
		logger.info("Getting Entity Manager..");
		return this.localContainerEntityManagerFactoryBean().getNativeEntityManagerFactory().createEntityManager();
	}

	/**
	 * Sets JPA Properties from properties file and Returns a map of properties
	 */
	@Bean
	public Map<String, Object> jpaProperties() {
		logger.info("Setting JPA Properties..");
		String connectionString = "jdbc:postgresql://" + environment.getProperty("spring.datasource.postgres.host")
				+ ":" + environment.getProperty("spring.datasource.postgres.port") + "/"
				+ environment.getProperty("spring.datasource.postgres.dbName");
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
		props.put("hibernate.connection.url", connectionString);
		props.put("connection.driver_class", "org.postgresql.Driver");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.connection.username", environment.getProperty("spring.datasource.postgres.username"));
		props.put("hibernate.connection.password", environment.getProperty("spring.datasource.postgres.password"));
		props.put("hibernate.show_sql", "true");
		return props;
	}

	/**
	 * Returns the JPA Vendor Adapter. In this context it is Hibernate. The Database
	 * is Set to Postgresql
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		logger.info("Setting JPA Vendor Adapter to Hibernate..");
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		return hibernateJpaVendorAdapter;
	}

	/**
	 * Builds and Returns the entity manager factory bean. Also depends on the Data
	 * Source Bean
	 */
	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		logger.info("Building Entity Manager Factory..");
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource());
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setPackagesToScan("com.test");
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}

	/**
	 * Returns the Platform Transaction manager bean which depends on the
	 * EntityManager Factory Bean
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		logger.info("Returning Platform Transaction Manager..");
		return new JpaTransactionManager(localContainerEntityManagerFactoryBean().getObject());
	}

	/**
	 * Returns the Transaction manager bean
	 */
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		logger.info("Building Transaction Manager..");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
