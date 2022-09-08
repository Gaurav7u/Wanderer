package com.wanderer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wanderer.model.PackageModel;
import com.wanderer.model.UserModel;

@Repository
public interface PackageRepository extends JpaRepository<PackageModel, Integer> {
	
    public List<PackageModel> findAllByUser(UserModel user);
	
	@Query("SELECT p FROM PackageModel p WHERE p.destination LIKE %?1%")
	public List<PackageModel> findAndSearchAll(String keyword);
	
	@Query("SELECT p FROM PackageModel p WHERE p.user.email=?1")
	public List<PackageModel> findAllByAdmin(String adminEmail);
	
	@Query("SELECT p FROM PackageModel p WHERE p.destination LIKE %?1% and p.user.email=?2")
	public List<PackageModel> findAndSearchAllByAdmin(String keyword,String adminEmail);

}
