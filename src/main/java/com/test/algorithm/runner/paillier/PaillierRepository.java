package com.test.algorithm.runner.paillier;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaillierRepository extends JpaRepository<Paillier, Serializable> {
	Paillier findById(int id);
}
