package masivian.test.roulettebetting.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import masivian.test.roulettebetting.constant.APIConstants;
import masivian.test.roulettebetting.constant.RedisConstant;
import masivian.test.roulettebetting.objects.Roulette;

@Repository
public class RouletteRedisRepository {

	@Autowired
	@Qualifier("redisRoullete")
	private RedisTemplate<String, Object> redisTemplateRoullete;

//	private List<Roulette> getAllRoulettes(){
//		
//		List<Roulette> listRoulettes = new ArrayList<>();
//		redisTemplateRoullete.opsForHash().
//		
//		
//	}
	public Roulette getRoulette(String idRoullete) {

		Roulette roulette = new Roulette();
		try {
			if (idRoullete != null) {
				String productJson = (String) redisTemplateRoullete.opsForHash().get(RedisConstant.HASH_ROULETTES,
						idRoullete);
				if (productJson != null && !productJson.isEmpty()) {
					Gson gson = new Gson();
					roulette = gson.fromJson(productJson, Roulette.class);
				}
			}
		} catch (Exception exception) {

		}
		return roulette;
	}

	public String saveRoulette(Roulette roulette) {

		String result = APIConstants.CODE_FAILED;
		Map<String, String> rouletteMap = new HashMap<>();
		if (roulette != null) {
			String json = new JSONObject(roulette).toString();
			rouletteMap.put(roulette.getIdRoulette(), json);
			if (!rouletteMap.isEmpty()) {
				saveRoulette(rouletteMap);
				result = APIConstants.CODE_SUCCESSFUL;
			}
		}

		return result;
	}

	public String loadListRoulettes(List<Roulette> rouletteList) {

		String result = APIConstants.CODE_FAILED;
		Map<String, String> roulettes = new HashMap<>();
		try {
			if (rouletteList != null && !rouletteList.isEmpty()) {
				rouletteList.stream().forEach(r -> {
					String json = new JSONObject(r).toString();
					roulettes.put(r.getIdRoulette(), json);
				});
				if (!roulettes.isEmpty()) {
					saveRoulettes(roulettes);
					result = APIConstants.CODE_SUCCESSFUL;
				} else {
					result = APIConstants.CODE_SUCCESSFUL;
				}
			}
		} catch (Exception exception) {
		}

		return result;
	}

	public void saveRoulette(Map<String, String> roulette) {
		if (roulette != null && !roulette.isEmpty()) {
			redisTemplateRoullete.opsForHash().putAll(RedisConstant.HASH_ROULETTES, roulette);
		}
	}

	public void saveRoulettes(Map<String, String> roulettes) {
		if (roulettes != null && !roulettes.isEmpty()) {

			redisTemplateRoullete.delete(RedisConstant.HASH_ROULETTES);
			redisTemplateRoullete.opsForHash().putAll(RedisConstant.HASH_ROULETTES, roulettes);
		}
	}

}
