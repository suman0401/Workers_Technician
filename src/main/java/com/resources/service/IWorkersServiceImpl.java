package com.resources.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resources.exception.WorkersNotFoundException;
import com.resources.model.Available;
import com.resources.model.Workers;
import com.resources.repository.IWorkersRepository;

@Service
public class IWorkersServiceImpl implements IWorkersService {
	@Autowired
	IWorkersRepository workersRepository;

	@Override
	public List<Workers> getallWorkers() {
		return workersRepository.findAll();
	}

	@Override
	public Workers getById(int workersId) throws WorkersNotFoundException {
		Workers workers = workersRepository.findById(workersId).get();
		if (workers == null) {
			throw new WorkersNotFoundException("invalid workersId");
		}
		return workers;
	}

	@Override
	public List<Workers> getByWorkersName(String workersName) throws WorkersNotFoundException {
		List<Workers> workersList = workersRepository.findByWorkersName(workersName);
		if (workersList.isEmpty()) {
			throw new WorkersNotFoundException("Invalid WorkersName");
		}
		return workersList;
	}

	@Override
	public List<Workers> getByWorkersType(String workersType) throws WorkersNotFoundException {
		List<Workers> workersList = workersRepository.findByWorkersType(workersType);
		if (workersList.isEmpty()) {
			throw new WorkersNotFoundException("Invalid WorkersType");
		}
		return workersList;
	}

	@Override
	public List<Workers> getByWorkersAvailableFrom(LocalDate workersavailablefrom) throws WorkersNotFoundException {
		List<Workers> workersList = workersRepository.findByWorkersavailablefrom(workersavailablefrom);
		if (workersList.isEmpty()) {
			throw new WorkersNotFoundException("Invalid Workers Available Date");
		}
		return workersList;
	}

	@Override
	public List<Workers> getByWorkersAvailability(Available availability) throws WorkersNotFoundException {
		List<Workers> workersList = workersRepository.findByAvailability(availability);
		if (workersList.isEmpty()) {
			throw new WorkersNotFoundException("Invalid WorkersType");
		}
		return workersList;
	}

	@Override
	public Workers addWorkers(Workers workers) {
		return workersRepository.save(workers);
	}

	@Override
	public void updateTaskId(int workersId,int taskId) {
		workersRepository.updateTaskId(workersId,taskId);
	}

	@Override
	public void removeTaskId(int taskId) {
		workersRepository.removeTaskId(taskId);;
		
	}

}
