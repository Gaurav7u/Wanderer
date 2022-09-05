package com.wanderer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.PackageModel;

@Repository
public interface PackageRepository extends JpaRepository<PackageModel, String> {

}
