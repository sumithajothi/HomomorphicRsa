/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

/**
 * 
 * @author Sumitha Jothiramalingam DTO object that holds Decrypted RSA specific
 *         fields
 */
public class RSADto {
	/**
	 * Generated Unique ID - Retrieved From DB
	 */
	int id;
	/**
	 * Decrypted Plain text
	 */
	String plainText;
	/**
	 * Cypher text which was used for decryption
	 */
	String cypherText;

	public RSADto() {
	}

	public RSADto(int id, String plainText, String cypherText) {
		super();
		this.id = id;
		this.plainText = plainText;
		this.cypherText = cypherText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public String getCypherText() {
		return cypherText;
	}

	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}

}
