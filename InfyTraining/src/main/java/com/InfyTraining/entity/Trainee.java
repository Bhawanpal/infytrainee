package com.InfyTraining.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="trainee")
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer traineeId;
	private String traineeName;
	private String traineeTech;
	private String traineeEmail;
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeTech() {
		return traineeTech;
	}
	public void setTraineeTech(String traineeTech) {
		this.traineeTech = traineeTech;
	}
	
	
	public String getTraineeEmail() {
		return traineeEmail;
	}
	public void setTraineeEmail(String traineeEmail) {
		this.traineeEmail = traineeEmail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(traineeEmail, traineeId, traineeName, traineeTech);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		return Objects.equals(traineeEmail, other.traineeEmail) && Objects.equals(traineeId, other.traineeId)
				&& Objects.equals(traineeName, other.traineeName) && Objects.equals(traineeTech, other.traineeTech);
	}
	
}
