package masivian.test.roulettebetting.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

public class ClientRedisRepository {

	@Autowired
	@Qualifier("redisClient")
	private RedisTemplate<String, Object> redisTemplateClient;
}
