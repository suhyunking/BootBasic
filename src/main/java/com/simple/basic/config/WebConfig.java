package com.simple.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.HomeController;
import com.simple.basic.util.UtilComponent;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// 스프링 설정파일로 사용할 클래스 (WebMvcConfigurer를 상속받습니다)

	// ioc컨테이너 안에 생성된 객체들을 확인할 수 있는 인터페이스
	@Autowired
	private ApplicationContext app;
	
	@Value("${spring.url}")
	private String url;

	@Bean
	public void test() {
		System.out.println("IOC컨테이너 빈 개수 :" + app.getBeanDefinitionCount());

		HomeController h = app.getBean(HomeController.class);
		System.out.println("IOC컨테이너 안에 빈 객체: " + h);
		System.out.println("홈컨트롤러 안에 메서드:" + h.home());

		// util 메서드 실행.

		// UtilComponent com = app.getBean(UtilComponent.class);
		// System.out.println("유틸컴포넌트 안에 메서드" + com.util());
		System.out.println(utilComponent().util());
		System.out.println();
		
	}
	
	@Bean // 빈으로 생성 
	public UtilComponent utilComponent() {
		return new UtilComponent();

	}
}
