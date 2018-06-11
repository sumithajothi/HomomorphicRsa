package com.test.algorithm.runner.paillier;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.algorithm.runner.auth.Response;
import com.test.algorithm.runner.homomorphicrsa.HomomorphicRsaController;

@Controller
public class PaillierController {
	@Autowired
	PaillierService paillierService;

	private static final Logger logger = LoggerFactory.getLogger(HomomorphicRsaController.class);

	@ResponseBody
	@RequestMapping(value = "api/v1/EncryptWithPaillier", method = RequestMethod.POST)
	public Response encryptPaillier(@RequestParam BigInteger data) {
		Response response = new Response();
		logger.info("Encrypting with Paillier..");
		try {
			return paillierService.encryptWithPaillier(data);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Encrypt");
			return response;
		}
	}

	@ResponseBody
	@RequestMapping(value = "api/v1/DecryptWithPaillier", method = RequestMethod.POST)
	public Response DecryptPaillier(@RequestParam int id) {
		Response response = new Response();
		logger.info("Decrypting with Paillier..");
		try {
			return paillierService.decryptWithPaillier(id);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Encrypt");
			return response;
		}
	}
}
