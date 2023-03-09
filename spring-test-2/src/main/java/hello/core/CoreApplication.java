package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // -> 여기 안에 @ComponentScan이 들어있다! (이 클래스가 들어있는 패키지부터 탐색 시작한다)
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
