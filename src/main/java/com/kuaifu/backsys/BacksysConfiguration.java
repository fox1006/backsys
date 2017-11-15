package com.kuaifu.backsys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@PropertySource("classpath:others.properties")
@EnableSwagger2
public class BacksysConfiguration {
	/**
	 * Swagger configuration method
	 * @return
	 */
	@Bean
	public Docket swaggerSettings() {
		String pathMapping="/";
		System.out.println("http://localhost:8080" + pathMapping + "/swagger-ui.html");
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("组织名吗")
				.useDefaultResponseMessages(true)
				.forCodeGeneration(false)
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any()) // 有待研究
				.build()
				.apiInfo(apiInfo())
				.pathMapping(pathMapping);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("后台系统 API")
				.description(initDescription())
				.version("1.0.0")
				.licenseUrl("http://cn.bing.com")
				.termsOfServiceUrl("https://www.baidu.com")
				.license("The Apache License, Version 2.0")
				.contact("后台开发团队")
				.build();
	}
	
	private String initDescription(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("本页面用来测试swagger提供的restful 接口文档功能")
			.append("<br/>")
			.append("包括增删改查四种例子： POST DELETE PUT GET")
			.append("<br/>")
			.append("REST API 设计应该注意哪些问题以及如何解决这些问题");
		
		return sb.toString();
	}
}
