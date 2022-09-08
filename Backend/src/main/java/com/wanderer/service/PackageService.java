package com.wanderer.service;

import java.util.List;

import com.wanderer.model.PackageModel;
import com.wanderer.exception.NotFoundException;

public interface PackageService {
	public PackageModel save(PackageModel p);
	PackageModel findPackageById(int id) throws NotFoundException;
	String deletePackageById(int id) throws NotFoundException;
	List<PackageModel> findAll(String keyword);
	List<PackageModel> findAllByAdmin(String keyWord, String adminEmail);
}
