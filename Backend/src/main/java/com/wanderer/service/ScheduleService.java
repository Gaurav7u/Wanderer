package com.wanderer.service;

import java.util.List;
import com.wanderer.model.ScheduleModel;

public interface ScheduleService {

	List<ScheduleModel> findAllByPackageId(int packageId);

	ScheduleModel save(ScheduleModel schedule);

	ScheduleModel findById(int id);

	String deleteById(int id);
}
