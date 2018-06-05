/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * General Application Configuration
 */
@Configuration
public class ApplicationBoot {

	@PostConstruct
	public void removeExistingSessions() {
	}

	/**
	 * Returns a Rest Template Bean
	 * 
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * Multipart Resolver to transact files over REST Web Services
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
}
