package com.wanderer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.BookingModel;
import com.wanderer.model.PackageModel;
import com.wanderer.model.UserModel;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, String>{

	public List<BookingModel> findAllByUser(UserModel user);
	public List<BookingModel> findAllByPackages(PackageModel p);
}
