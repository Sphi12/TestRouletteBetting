package masivian.test.roulettebetting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import masivian.test.roulettebetting.constant.APIConstants;
import masivian.test.roulettebetting.service.IRouletteService;

@RestController
@RequestMapping("roulettebetting/roulette")
@Validated
public class RouletteController {

	@Autowired
	private IRouletteService roulleteService;

	@PutMapping(path = "addRoullete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modifyCharge(BindingResult result) {

		try {
			String responseMessage = roulleteService.addRoulette();
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(APIConstants.CODE_FAILED, HttpStatus.OK);
		}
	}
}
