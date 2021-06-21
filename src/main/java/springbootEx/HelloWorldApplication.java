package springbootEx;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/*
 * Bootstrap Class
 * 
 * 1. 스프링 부트 애플리케이션의 Bootstrapping(부트스트래핑/와이어링)
 * 2. 설정 클래스로 역할 (Configuration Class)
 */

//@SpringBootConfiguration 메타 어노테이션
// (@SpringBootConfiguration(alias for @Configuration) + @ComponentScan + @AutoConfiguration)

@SpringBootConfiguration
public class HelloWorldApplication {
	@Bean
	public ApplicationRunner applicationRunner() {
		// 1. 작성된 구현 클래스를 사용
		// return new HelloWorldRunner();
		
		// 2. anonymouse class 사용
//		return new ApplicationRunner() {
//			
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//				System.out.println("Hello World!!!");
//			}
//		};
		
		// 3. 함수형(람다 표현식)
		return (ApplicationArguments args) -> {
			System.out.println("Hello World!!!!");
		};
	}
	
	public static void main(String[] args) {
		/*
		 * 1. Application Context(Container) 생성
		 * 2. Application Type 결정 ( Web - Servlet, Reactive )
		 * 	- starter를 보고 결정
		 * 3. Annotation scanning을 통한 빈 생성 및 등록
		 * 4. Web Application인 경우
		 * 	- 내장(Embedded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
		 * 	- 서버 인스턴스에 Web Application 을 배포
		 * 	- 서버 인스턴스 실행
		 * 5. 인터페이스 ApplicationRunner 구현 빈의 run() 실행
		 */
		SpringApplication.run(HelloWorldApplication.class, args);
		
	}

}
