package com.wanderer.controller;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wanderer.dto.ScheduleDto;
import com.wanderer.exception.NotFoundException;
import com.wanderer.model.PackageModel;
import com.wanderer.model.ScheduleModel;
import com.wanderer.serviceImpl.PackageServiceImpl;
import com.wanderer.serviceImpl.ScheduleServiceImpl;

@RestController
@RequestMapping("/schedule/")
public class ScheduleController {

	@Autowired
	PackageServiceImpl packageService;
	@Autowired
	ScheduleServiceImpl scheduleService;
	
	@GetMapping()
	public ResponseEntity<List<ScheduleModel>> getSchedule(@RequestParam() int packageId) {
		return new ResponseEntity<>(scheduleService.findAllByPackageId(packageId), HttpStatus.OK);
	}
	
	@PostMapping("{packageId}")
	public ResponseEntity<ScheduleModel> insertSchedule( @Valid @RequestBody() ScheduleDto schedule,@PathVariable int packageId)
			throws IOException{
		PackageModel p = packageService.findPackageById(packageId);
		ScheduleModel s = new ScheduleModel();
		s.setDayOrNightNo(schedule.getDayOrNightNo());
		s.setDescription(schedule.getDescription());
		s.setPackages(p);
		ScheduleModel savedSchedule = scheduleService.save(s);
		return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSchedule(@PathVariable int id) throws NotFoundException {
		ScheduleModel schedule = scheduleService.findById(id);
		if (schedule != null)
			return new ResponseEntity<>(scheduleService.deleteById(id), HttpStatus.OK);
		else
			throw new NotFoundException("id " + id + " not found");
	}
}
