package com.hcc.oAuth2WithMySql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
			.requestMatchers()
				.antMatchers("/api/public", "/oauth/token", "/oauth/authorize**")
					.and()
					.authorizeRequests().antMatchers("/api/public", "/oauth/token", "/oauth/authorize**").permitAll()
				.and()
			.requestMatchers()
				.antMatchers("/api/private")
					.and()
					.authorizeRequests().antMatchers("/api/private").hasAuthority("USER")
				.and()
			.requestMatchers()
				.antMatchers("/api/admin")
					.and()
					.authorizeRequests().antMatchers("/api/admin").access("hasAuthority('ADMIN')");
		
	}

}
