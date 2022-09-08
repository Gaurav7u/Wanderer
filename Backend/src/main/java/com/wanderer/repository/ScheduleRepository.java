package com.wanderer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanderer.model.PackageModel;
import com.wanderer.model.ScheduleModel;
@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleModel, Integer> {

	List<ScheduleModel> findAllByPackages(PackageModel packages);
}
