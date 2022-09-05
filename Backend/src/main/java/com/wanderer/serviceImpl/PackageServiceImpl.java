package com.wanderer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.model.PackageModel;
import com.wanderer.repository.PackageRepository;
import com.wanderer.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	PackageRepository prepo;
	@Override
	public PackageModel save(PackageModel p) {
		return prepo.save(p);
	}

	@Override
	public List<PackageModel> findAll() {
		return prepo.findAll();
	}

}
