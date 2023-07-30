package com.InfyTraining.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InfyTraining.DTO.TraineeDTO;
import com.InfyTraining.entity.Trainee;
import com.InfyTraining.exception.InfyTrainingException;
import com.InfyTraining.repository.TraineeRepository;



@Service
public class TraineeServiceImpl {
	@Autowired
	private TraineeRepository repo;
	
public TraineeDTO getTraineeId(Integer traineeId) throws InfyTrainingException {
	Optional<Trainee> optionalTrainee = repo.findById(traineeId);
	Trainee trainee = optionalTrainee.orElseThrow( ()-> new InfyTrainingException("Service.TRAINEE_NOT_FOUND"));
	TraineeDTO traineeDTO = new TraineeDTO();
	traineeDTO.setTraineeId(traineeId);
	traineeDTO.setTraineeName(trainee.getTraineeName());
	traineeDTO.setTraineeTech(trainee.getTraineeTech());
	traineeDTO.setTraineeEmail(trainee.getTraineeEmail());
	return traineeDTO;
}
	
	public List<TraineeDTO> listAll() throws  InfyTrainingException{
		Iterable<Trainee> trainees = repo.findAll();
		List<TraineeDTO> trainees2 = new ArrayList<>();
		trainees.forEach(trainee -> {
			TraineeDTO tr = new TraineeDTO();
			tr.setTraineeId(trainee.getTraineeId());
			tr.setTraineeName(trainee.getTraineeName());
			tr.setTraineeTech(trainee.getTraineeTech());
			tr.setTraineeEmail(trainee.getTraineeEmail());
			trainees2.add(tr);
		});
		if (trainees2.isEmpty())
			throw new InfyTrainingException ("Service.TRAINEEE_NOT_FOUND");
		return trainees2;
	}
	
	public void updateTrainee(Integer traineeId,TraineeDTO traineeDTO) throws InfyTrainingException{
		
		Optional<Trainee> optionalTrainee = repo.findById(traineeId);
		Trainee trainee = optionalTrainee.orElseThrow(() -> new InfyTrainingException("Service.TRAINEEE_NOT_FOUND"));
		TraineeDTO traineeDTO1 = new TraineeDTO();
		traineeDTO1.setTraineeId(traineeId);
		traineeDTO1.setTraineeName(trainee.getTraineeName());
		traineeDTO1.setTraineeTech(trainee.getTraineeTech());
		traineeDTO1.setTraineeEmail(trainee.getTraineeEmail());
	}
}
	