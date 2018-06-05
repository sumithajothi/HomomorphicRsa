/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.rsa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Sumitha Jothiramalingam Repository Interface that extends
 *         functionality of JPA Repository
 */
@Repository
public interface RSARepository extends JpaRepository<RSA, Serializable> {
	/**
	 * Finds RSA entity based on ID
	 * 
	 * @param id
	 *            id that points to the specific record in the DB
	 * @return RSA object from DB
	 */
	RSA findById(int id);
}
