package com.wanderer.service;

import java.util.List;

import com.wanderer.model.AmenetiesModel;

public interface AmenetiesService {

	List<AmenetiesModel> findAllByPackageId(int packageId);

	AmenetiesModel save(AmenetiesModel ameneties);

	AmenetiesModel findById(int id);

	String deleteById(int id);

}
