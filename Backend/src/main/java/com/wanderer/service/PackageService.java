package com.wanderer.service;

import java.util.List;

import com.wanderer.model.PackageModel;

public interface PackageService {
	public PackageModel save(PackageModel p);
	public List<PackageModel> findAll();
}
