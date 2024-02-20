package com.example.springbatchexample.domain.repository;

import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricVehiclePopulationRepository extends JpaRepository<ElectricVehiclePopulation,Long> {
}
