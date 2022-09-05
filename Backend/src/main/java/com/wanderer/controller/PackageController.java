package com.wanderer.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wanderer.dto.PackageModelNoImage;
import com.wanderer.model.PackageModel;
import com.wanderer.serviceImpl.PackageServiceImpl;

@RestController
@RequestMapping("/packages/")
public class PackageController {
	
	@Autowired
	PackageServiceImpl packageService;
	
	@GetMapping("user")
	public ResponseEntity<List<PackageModel>> getPackages() {
		return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PackageModel> insertProduct( @Valid @ModelAttribute PackageModelNoImage packages , @RequestParam("packageImage") MultipartFile multipartFile)
			throws IOException{
		PackageModel p2 = new PackageModel();
		String imageUrl = StringUtils.cleanPath( multipartFile.getOriginalFilename());
		p2.setHeading(packages.getHeading());
		p2.setDestination(packages.getDestination());
		p2.setDays(packages.getDays());
		p2.setNights(packages.getNights());
		p2.setSeats(packages.getSeats());
		p2.setPrice(packages.getPrice());
		p2.setImageUrl(imageUrl);
		PackageModel savedPackage = packageService.save(p2);
		String uploadDir = "package-photos/" + savedPackage.getPackageId();
		com.wanderer.config.FileUploadUtil.saveFile(uploadDir, imageUrl, multipartFile);
		return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
	}
}
