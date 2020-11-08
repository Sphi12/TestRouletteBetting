package masivian.test.roulettebetting;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootApplication
@Import({ RedisTemplate.class })
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@PostConstruct
//	public void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
//	}

}
