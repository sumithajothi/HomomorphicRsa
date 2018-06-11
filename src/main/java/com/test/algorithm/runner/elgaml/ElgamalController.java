package com.test.algorithm.runner.elgaml;

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
public class ElgamalController {

	private static final Logger logger = LoggerFactory.getLogger(HomomorphicRsaController.class);
	@Autowired
	ElgamalService elgamalService;

	@ResponseBody
	@RequestMapping(value = "api/v1/EncryptWithElgamal", method = RequestMethod.POST)
	public Response encryptPaillier(@RequestParam BigInteger data, @RequestParam BigInteger secretKey) {
		Response response = new Response();
		logger.info("Encrypting with Elgamal..");
		try {
			return elgamalService.ecnrypt("" + data, "" + secretKey);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Encrypt");
			return response;
		}
	}

	@ResponseBody
	@RequestMapping(value = "api/v1/DecryptWithElgamal", method = RequestMethod.POST)
	public Response encryptPaillier(@RequestParam int id, @RequestParam String secretKey) {
		Response response = new Response();
		logger.info("Decrypting with Elgamal..");
		try {
			return elgamalService.decrypt(id, secretKey);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Decrypt");
			return response;
		}
	}
}
