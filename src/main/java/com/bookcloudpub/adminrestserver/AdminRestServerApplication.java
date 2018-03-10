package com.bookcloudpub.adminrestserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
//@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
//@EnableSwagger2
@EnableResourceServer
public class AdminRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminRestServerApplication.class, args);
	}
//
//	@Bean
//	public Docket newsApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("bookcloudpub")
//				.apiInfo(apiInfo())
//				.select()
//				.paths(PathSelectors.ant("/**"))
//				.build();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("책구름 Admin REST Server")
				.description("책구름 Admin REST Server")
				.contact(new Contact("정태준", "www.bookcloudpub.com", "jungtaejoon@gmail.com"))
				.version("1.0")
				.build();
	}

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
						.anyRequest().authenticated()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
			;
		}
	}
}
