package com.resources.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resources.model.Available;
import com.resources.model.Workers;
import com.resources.service.IWorkersService;

@RestController
@RequestMapping("/workers-service")
public class WorkersController {
	@Autowired
	IWorkersService workersService;

	@GetMapping("/workers")
	ResponseEntity<List<Workers>> getallWorkers() {
		List<Workers> allworkers = workersService.getallWorkers();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing all workers");
		return ResponseEntity.ok().headers(headers).body(allworkers);

	}

	@GetMapping("/workers/workersId/{workersId}")
	ResponseEntity<Workers> getById(@PathVariable("workersId") int workersId) {
		Workers workers = workersService.getById(workersId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing workers by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(workers);

	}

	@GetMapping("/workers/workersname/{workersname}")
	ResponseEntity<List<Workers>> getByWorkersName(@PathVariable("workersname") String workersName) {
		List<Workers> workersname = workersService.getByWorkersName(workersName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing workers by name");
		return ResponseEntity.ok().headers(headers).body(workersname);

	}

	@GetMapping("/workers/workerstype/{workerstype}")
	ResponseEntity<List<Workers>> getByWorkersType(@PathVariable("/workerstype") String workersType) {
		List<Workers> workerstype = workersService.getByWorkersType(workersType);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing workers by type");
		return ResponseEntity.ok().headers(headers).body(workerstype);

	}

	@GetMapping("/workers/workersavailablefrom/{availablefrom}")
	ResponseEntity<List<Workers>> getByWorkersAvailableFrom(
			@PathVariable("availablefrom") String workersavailablefrom) {
		List<Workers> workersavailabledate = workersService
				.getByWorkersAvailableFrom(LocalDate.parse(workersavailablefrom));
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing workers by available date ");
		return ResponseEntity.ok().headers(headers).body(workersavailabledate);

	}

	@GetMapping("/workers/availability/{availability}")
	ResponseEntity<List<Workers>> getByWorkersAvailability(@PathVariable("availability") Available availability) {
		List<Workers> workersavailability = workersService.getByWorkersAvailability(availability);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "showing workers by availability");
		return ResponseEntity.ok().headers(headers).body(workersavailability);

	}

	@GetMapping("workers/task/workersId/{workersId}/taskId/{taskId}")
	ResponseEntity<String> updateTaskId(int workersId,int taskId) {
		workersService.updateTaskId(workersId,taskId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Task Id updated successfully");
		return ResponseEntity.ok().headers(headers).body("Updated Successfully");

	}

	@GetMapping("/task/workersId/{workersId}/taskId/{taskId}")
	ResponseEntity<String> removeTaskId(int taskId) {
		workersService.removeTaskId(taskId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Task Id removed successfully");
		return ResponseEntity.ok().headers(headers).body("removed Successfully");

	}
	//****************************************FROM TASK*******************************************************


}
