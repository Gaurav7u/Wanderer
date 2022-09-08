package com.wanderer.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wanderer.dto.PackageModelNoImage;
import com.wanderer.exception.NotFoundException;
import com.wanderer.model.PackageModel;
import com.wanderer.serviceImpl.PackageServiceImpl;
import com.wanderer.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/packages/")
public class PackageController {
	
	@Autowired
	PackageServiceImpl packageService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("user")
	public ResponseEntity<List<PackageModel>> getPackages(@RequestParam() String keyWord) {
		return new ResponseEntity<>(packageService.findAll(keyWord), HttpStatus.OK);
	}
	@GetMapping("admin")
	public ResponseEntity<List<PackageModel>> getPackages(@RequestParam() String keyWord,Principal principal) {
		return new ResponseEntity<>(packageService.findAllByAdmin(keyWord,principal.getName()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PackageModel> insertPackage( @Valid @ModelAttribute PackageModelNoImage packages , @RequestParam("packageImage") MultipartFile multipartFile, Principal principal)
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
		p2.setUser(userService.findByEmail(principal.getName()));
		PackageModel savedPackage = packageService.save(p2);
		String uploadDir = "package-photos/" + savedPackage.getPackageId();
		com.wanderer.config.FileUploadUtil.saveFile(uploadDir, imageUrl, multipartFile);
		return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PackageModel> updateProduct(@PathVariable("id") int id,
			@ModelAttribute PackageModelNoImage packages) throws NotFoundException {
		return new ResponseEntity<>(packageService.update(packages, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePackage(@PathVariable int id) throws NotFoundException {
		PackageModel packages = packageService.findPackageById(id);
		if (packages != null)
			return new ResponseEntity<>(packageService.deletePackageById(id), HttpStatus.OK);
		else
			throw new NotFoundException("id " + id + " not found");
	}
}
