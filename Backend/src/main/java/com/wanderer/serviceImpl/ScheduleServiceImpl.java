package com.wanderer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.exception.NotFoundException;
import com.wanderer.model.PackageModel;
import com.wanderer.model.ScheduleModel;
import com.wanderer.repository.PackageRepository;
import com.wanderer.repository.ScheduleRepository;
import com.wanderer.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	PackageRepository prepo;
	@Autowired
	ScheduleRepository srepo;
	@Override
	public List<ScheduleModel> findAllByPackageId(int packageId) {
		PackageModel packages=prepo.findById(packageId).orElseThrow( ()->new NotFoundException("package not found with id: "+packageId));
		return srepo.findAllByPackages(packages);
	}

	@Override
	public ScheduleModel save(ScheduleModel schedule) {
		return srepo.save(schedule);
	}

	@Override
	public ScheduleModel findById(int id) {
		return srepo.findById(id).orElseThrow( ()->new NotFoundException("schedule not found with id: "+id));
	}

	@Override
	public String deleteById(int id) {
		ScheduleModel schedule = findById(id);
		srepo.deleteById(id);
		return schedule.getDescription() + " Deleted";
	}

}
