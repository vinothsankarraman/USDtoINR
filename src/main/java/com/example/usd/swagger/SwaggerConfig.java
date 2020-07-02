package com.example.usd.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket usdApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.usd"))
				.paths(regex("/usd.*"))
				.build()
				.apiInfo(metadata());
	}
	
	private ApiInfo metadata() {
		
		
		  return new ApiInfoBuilder() 
				  .title("USD to INR")
				  .description("\"USD to INR conversion\"") 
				  .version("1.0.0")
				  .license("License")
				  .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				  .contact(new
				  Contact("Vinoth Sankarraman", "About", "vinothemailbox@gmail.com"))
				  .build();
				
	}
	
	

}
