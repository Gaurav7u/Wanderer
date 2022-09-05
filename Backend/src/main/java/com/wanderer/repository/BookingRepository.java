package com.wanderer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.BookingModel;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, String>{

}
