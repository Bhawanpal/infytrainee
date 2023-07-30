package com.InfyTraining.service;

import java.util.List;

import com.InfyTraining.DTO.TraineeDTO;
import com.InfyTraining.exception.InfyTrainingException;


public interface TraineeService {
	
	public TraineeDTO getTraineeId(Integer traineeId) throws InfyTrainingException;
	
	public List<TraineeDTO> listAll() throws  InfyTrainingException;
	
	public void updateTrainee(Integer traineeId,TraineeDTO traineeDTO) throws InfyTrainingException;
	
	 public void deleteTrainee(Integer traineeId) throws InfyTrainingException;

	 public Integer addTrainee(TraineeDTO traineeDTO) throws InfyTrainingException;

	
}
