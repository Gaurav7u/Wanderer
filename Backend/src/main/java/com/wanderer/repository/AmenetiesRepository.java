package com.wanderer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.AmenetiesModel;
import com.wanderer.model.PackageModel;

@Repository
public interface AmenetiesRepository extends JpaRepository<AmenetiesModel, Integer> {
  
	List<AmenetiesModel> findAllByPackages(PackageModel packages);

}
