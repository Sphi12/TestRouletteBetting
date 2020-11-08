package masivian.test.roulettebetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import masivian.test.roulettebetting.constant.APIConstants;
import masivian.test.roulettebetting.objects.Roulette;
import masivian.test.roulettebetting.redis.RouletteRedisRepository;

@Component
public class RouletteService implements IRouletteService {

	@Autowired
	private RouletteRedisRepository repository;

	public String addRoulette() {

		String id = generateId(6);
		try {
			String result = repository.saveRoulette(new Roulette(id, APIConstants.CLOSED_STATUS));
			if (result.equals(APIConstants.CODE_SUCCESSFUL))
				return id;
		} catch (Exception exception) {

		}
		return null;
	}

	public static String generateId(final int tamanio) {

		int number1 = 48;
		int number2 = 122;
		StringBuilder random = new StringBuilder();
		for (int i = 1; i <= tamanio; i++) {
			if (i == tamanio) {
				number2 = 57;
			}
			int rendomNumber = (int) Math.floor(Math.random() * (number2 - number1) + number1);
			if ((rendomNumber > 57 && rendomNumber < 65) || (rendomNumber > 90 && rendomNumber < 97)) {
				rendomNumber += 7;
			}
			random.append((char) rendomNumber);
		}

		return random.toString();
	}

}
