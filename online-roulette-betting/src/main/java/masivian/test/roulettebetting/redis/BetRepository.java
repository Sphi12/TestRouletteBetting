package masivian.test.roulettebetting.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BetRepository {

	@Autowired
	@Qualifier("redisBet")
	private RedisTemplate<String, Object> redisTemplateBet;
}
