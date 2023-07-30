package com.InfyTraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InfyTraining.entity.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee,Integer>  {

}
