package com.test.algorithm.runner.elgaml;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElgamalRepository extends JpaRepository<Elgamal, Serializable> {
	Elgamal findById(int id);
}
