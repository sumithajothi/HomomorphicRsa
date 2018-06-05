/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.homomorphicrsa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Sumitha Jothiramalingam Repository Interface that extends
 *         functionality of JPA Repository
 */
@Repository
public interface HomomorphicRsaRepository extends JpaRepository<HomomorphicRsa, Serializable> {
	/**
	 * Finds HomomorphicRsa entity based on ID
	 * 
	 * @param id
	 *            id that points to the specific record in the DB
	 * @return HomomorphicRsa object from DB
	 */
	HomomorphicRsa findById(int id);
}
