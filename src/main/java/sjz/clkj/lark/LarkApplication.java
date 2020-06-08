package sjz.clkj.lark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class LarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(LarkApplication.class, args);
	}

}
