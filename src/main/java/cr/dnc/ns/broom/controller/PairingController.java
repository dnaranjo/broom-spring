package cr.dnc.ns.broom.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cr.dnc.ns.broom.business.PairingLogic;
import cr.dnc.ns.broom.domain.Pair;
import cr.dnc.ns.broom.dto.PairingResponse;

@RestController
public class PairingController {
	@Autowired
	private final PairingLogic pairingLogic = new PairingLogic();
	
	@RequestMapping(value = "/pair", method = RequestMethod.POST, consumes = {"application/json"})
	public PairingResponse process(@RequestBody final List<Pair> pairs) {
		//PairingInputParam requestParam = gson.fromJson("{\"pairs\":[{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Washington\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mary\"},{\"category\":{\"name\":\"COMPUTER\"},\"subCategory\":\"Mac\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"OTHER\"},\"subCategory\":\"Tree\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Dog\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Texas\"},{\"category\":{\"name\":\"FOOD\"},\"subCategory\":\"Steak\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Cat\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mac\"}]}", PairingInputParam.class);
		return new PairingResponse(pairingLogic.process(pairs));
	}
}
