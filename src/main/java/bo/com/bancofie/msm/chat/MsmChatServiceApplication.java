package bo.com.bancofie.msm.chat;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"bo.com.bancofie"})
@OpenAPIDefinition(info = @Info(title = "Chat Service", version = "1.0", description = "Chat Manegement"))
public class MsmChatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsmChatServiceApplication.class, args);
	}

}
