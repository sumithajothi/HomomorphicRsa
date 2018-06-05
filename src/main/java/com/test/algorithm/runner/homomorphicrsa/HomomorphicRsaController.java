/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

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

/**
 * 
 * @author Sumitha Jothiramalingam REST API methods specific to Homomorphic
 *         encryption and decryption are contained in this controller
 */
@Controller
public class HomomorphicRsaController {
	/**
	 * Bean Injected From Service
	 */
	@Autowired
	HomomorphicRsaService homomorphicRsaService;

	private static final Logger logger = LoggerFactory.getLogger(HomomorphicRsaController.class);

	/**
	 * Encrypts data with Homomorphic Encryption Technique
	 * 
	 * @param valueOne
	 *            First User Input that has to be encrypted
	 * @param valueTwo
	 *            - Second User Input that has to be encrypted
	 * @return {@link Response} object with response data that contains ID of
	 *         encrypted record stored in the cloud, status and exceptions if any
	 */
	@ResponseBody
	@RequestMapping(value = "api/v1/EncryptHomomorphicRsa", method = RequestMethod.POST)
	public Response encryptHomomorphicRsa(@RequestParam BigInteger valueOne, @RequestParam BigInteger valueTwo) {
		Response response = new Response();
		logger.info("Encrypting wit Homomorphic RSA..");
		try {
			return homomorphicRsaService.encryptData(valueOne, valueTwo);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Decrypt");
			return response;
		}
	}

	/**
	 * Decrypts data with Homomorphic Encryption Technique, that was encrypted with
	 * the same technique
	 * 
	 * @param id
	 *            The ID that was returned during encryption - This indicates the
	 *            record identifier of encrypted data stored in the cloud DB
	 * @return {@link Response} object with response data, status and exceptions if
	 *         any
	 */
	@ResponseBody
	@RequestMapping(value = "api/v1/DecryptHomomorphicRsa", method = RequestMethod.POST)
	public Response decryptHomomorphicRsa(@RequestParam int id) {
		Response response = new Response();
		logger.info("Encrypting wit Homomorphic RSA..");
		try {
			return homomorphicRsaService.decryptData(id);
		} catch (Exception e) {
			e.printStackTrace();
			response.setIsException(true);
			response.setResponseMessage("Failed To Decrypt");
			return response;
		}
	}
}
