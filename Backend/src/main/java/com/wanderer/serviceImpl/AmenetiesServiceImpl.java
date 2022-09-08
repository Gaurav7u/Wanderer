package com.wanderer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.exception.NotFoundException;
import com.wanderer.model.AmenetiesModel;
import com.wanderer.model.PackageModel;
import com.wanderer.repository.AmenetiesRepository;
import com.wanderer.repository.PackageRepository;
import com.wanderer.service.AmenetiesService;

@Service
public class AmenetiesServiceImpl implements AmenetiesService{
	
	@Autowired
	PackageRepository prepo;
	@Autowired
	AmenetiesRepository arepo;
	
	@Override
	public List<AmenetiesModel> findAllByPackageId(int packageId)
	{
		PackageModel packages=prepo.findById(packageId).orElseThrow( ()->new NotFoundException("package not found with id: "+packageId));
		return arepo.findAllByPackages(packages);
	}
	@Override
	public AmenetiesModel save(AmenetiesModel ameneties) {
		return arepo.save(ameneties);
	}
	@Override
	public AmenetiesModel  findById(int id)
	{
		return arepo.findById(id).orElseThrow( ()->new NotFoundException("ameneties not found with id: "+id));
	}
	@Override
	public String  deleteById(int id)
	{
		AmenetiesModel ameneties = findById(id);
		arepo.deleteById(id);
		return ameneties.getDescription() + " Deleted";
	}

}
