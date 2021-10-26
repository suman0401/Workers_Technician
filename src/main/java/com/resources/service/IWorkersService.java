package com.resources.service;

import java.time.LocalDate;
import java.util.List;

import com.resources.exception.WorkersNotFoundException;
import com.resources.model.Available;
import com.resources.model.Workers;


public interface IWorkersService {
	Workers addWorkers(Workers workers);
	
	List<Workers> getallWorkers();
	Workers getById(int workersId) throws WorkersNotFoundException;
	List<Workers> getByWorkersName(String workersName)throws WorkersNotFoundException;
	List<Workers> getByWorkersType(String workersType)throws WorkersNotFoundException;
	List<Workers> getByWorkersAvailability(Available availability)throws WorkersNotFoundException;
	List<Workers> getByWorkersAvailableFrom(LocalDate workersavailablefrom)throws WorkersNotFoundException;
	
	
	
	void updateTaskId(int workersId, int taskId);
	void removeTaskId(int taskId);

}
