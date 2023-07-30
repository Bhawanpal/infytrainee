package com.InfyTraining.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InfyTraining.DTO.TraineeDTO;
import com.InfyTraining.exception.InfyTrainingException;
import com.InfyTraining.service.TraineeService;


@CrossOrigin
@RestController
@RequestMapping(value = "/trainee-api")
public class TrainingApi {
	
	@Autowired
	TraineeService traineeService;
	
	@Autowired
	Environment environment;
	
	static Log logger = LogFactory.getLog(TrainingApi.class);
	
	@PostMapping(value = "/trainees")
	public ResponseEntity<String> addTrainee( @RequestBody TraineeDTO TraineeDTO) throws InfyTrainingException{
		Integer traineeId = traineeService.addTrainee(TraineeDTO);
		logger.info("trainee Added successfully");
		String successMsg = environment.getProperty("API.INSERT_SUCCESS") + traineeId;
		return new ResponseEntity<>(successMsg, HttpStatus.OK);
	}
	@GetMapping(value = "/trainees/{traineeId}")
	public ResponseEntity<TraineeDTO> getTrainee(@PathVariable("traineeId") Integer traineeId) throws InfyTrainingException{
		TraineeDTO TraineeDTO = traineeService.getTraineeId(traineeId);
		logger.info("Fetched successfully");
		return new ResponseEntity<>(TraineeDTO, HttpStatus.CREATED);
	}
	@GetMapping(value = "/trainees")
	public ResponseEntity<List<TraineeDTO>> listAll() throws InfyTrainingException {
		List<TraineeDTO> traineeList = traineeService.listAll();
		return new ResponseEntity<>(traineeList, HttpStatus.OK);
	}
	@DeleteMapping(value = "/trainees/{traineeId}")
	public ResponseEntity<String> deleteTrainee(@PathVariable Integer traineeId) throws InfyTrainingException {
		traineeService.deleteTrainee(traineeId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/trainees/{traineeId}")
    public ResponseEntity<String> updateTrainee(@PathVariable Integer traineeId, @RequestBody TraineeDTO trainee) throws InfyTrainingException{
    	
		traineeService.updateTrainee(traineeId,trainee);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

}
