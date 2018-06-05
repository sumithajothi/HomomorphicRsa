/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

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
 * @author Sumitha Jothiramalingam REST API methods specific to RSA encryption
 *         and decryption are contained in this controller
 */
@Controller
public class RSAController {
	private static final Logger logger = LoggerFactory.getLogger(RSAController.class);
	/**
	 * Bean Injected From Service
	 */
	@Autowired
	RSAService rsaService;

	/**
	 * @param plainText
	 *            Plain text that has to be encrypted with RSA Algorithm
	 * @return {@link Response} object with response data that contains ID of
	 *         encrypted record stored in the cloud, status and exceptions if any
	 */
	@ResponseBody
	@RequestMapping(value = "api/v1/BuildRSA", method = RequestMethod.GET)
	public Response getUser(@RequestParam String plainText) {
		Response response = new Response();
		logger.info("Building RSA..");
		try {
			return rsaService.buildAndProcessRsa(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @param id
	 *            The ID that was returned during encryption - This indicates the
	 *            record identifier of encrypted data stored in the cloud DB
	 * @return {@link Response} object with response data, status and exceptions if
	 *         any
	 */
	@ResponseBody
	@RequestMapping(value = "api/v1/GetStoredPlainText", method = RequestMethod.GET)
	public Response getPlainText(@RequestParam int id) {
		Response response = new Response();
		logger.info("Decrypting with RSA..");
		try {
			return rsaService.getPlainText(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
