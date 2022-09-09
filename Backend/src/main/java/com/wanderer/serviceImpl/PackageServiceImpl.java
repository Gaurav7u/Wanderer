package com.wanderer.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.dto.PackageModelNoImage;
import com.wanderer.exception.NotFoundException;
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
	public PackageModel findPackageById(int id) throws NotFoundException {
		return prepo.findById(id).orElseThrow(()->new NotFoundException("package not found with id: "+id));
	}
	@Override
	public String deletePackageById(int id) throws NotFoundException {
		PackageModel packages = findPackageById(id);
		prepo.deleteById(id);
		return packages.getHeading() + " Deleted";
	}
	public PackageModel update(PackageModelNoImage p,int id) throws NotFoundException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		PackageModel packages=findPackageById(id);
		packages.setHeading(p.getHeading());
		packages.setDestination(p.getDestination());
		packages.setDays(p.getDays());
		packages.setNights(p.getNights());
		packages.setSeats(p.getSeats());
		packages.setJourneyDate(LocalDate.parse(p.getJourneyDate(), formatter));
		packages.setPrice(p.getPrice());
		return save(packages);
	}
	@Override
	public List<PackageModel> findAll(String keyword) {
		if (keyword != null) {
            return prepo.findAndSearchAll(keyword);
        }
		return prepo.findAll();
	}
	@Override
	public List<PackageModel> findAllByAdmin(String keyWord,String adminEmail) {
		if (keyWord != null) {
            return prepo.findAndSearchAllByAdmin(keyWord,adminEmail);
        }
		return prepo.findAllByAdmin(adminEmail);
	}
	

}
