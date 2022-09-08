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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wanderer.dto.AmenetiesDto;
import com.wanderer.exception.NotFoundException;
import com.wanderer.model.AmenetiesModel;
import com.wanderer.model.PackageModel;
import com.wanderer.serviceImpl.AmenetiesServiceImpl;
import com.wanderer.serviceImpl.PackageServiceImpl;

@RestController
@RequestMapping("/ameneties/")
public class AmenetiesController {
	@Autowired
	AmenetiesServiceImpl amenetiesService;
    @Autowired
	PackageServiceImpl packageService;
	
	@GetMapping()
	public ResponseEntity<List<AmenetiesModel>> getAmeneties(@RequestParam() int packageId) {
		return new ResponseEntity<>(amenetiesService.findAllByPackageId(packageId), HttpStatus.OK);
	}
	@PostMapping("{packageId}")
	public ResponseEntity<AmenetiesModel> insertAmeneties( @Valid @RequestParam() AmenetiesDto ameneties,@PathVariable int packageId)
			throws IOException{
		PackageModel p = packageService.findPackageById(packageId);
		AmenetiesModel a = new AmenetiesModel();
		a.setDescription(ameneties.getDescription());
		a.setPackages(p);
		AmenetiesModel savedAmeneties = amenetiesService.save(a);
		return new ResponseEntity<>(savedAmeneties, HttpStatus.CREATED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePackage(@PathVariable int id) throws NotFoundException {
		AmenetiesModel ameneties = amenetiesService.findById(id);
		if (ameneties != null)
			return new ResponseEntity<>(amenetiesService.deleteById(id), HttpStatus.OK);
		else
			throw new NotFoundException("id " + id + " not found");
	}

}
