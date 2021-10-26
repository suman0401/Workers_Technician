package com.resources.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.resources.model.Available;
import com.resources.model.Workers;
@Repository
public interface IWorkersRepository extends JpaRepository<Workers, Integer> {
	
//derived queries
	List<Workers> findByWorkersName(String workersName);
	List<Workers> findByWorkersType(String workersType);
	List<Workers> findByWorkersavailablefrom(LocalDate availableFrom);
	List<Workers> findByAvailability(Available availability);
	
	@Modifying
	@Query(value = "update workers tables set task_id=?1 where workers_id=?2",nativeQuery = true)
	void updateTaskId(int workersId,int taskId);
	
	@Modifying
	@Query(value = "update workers tables set task_id=NULL where workers_id=?2",nativeQuery = true)
	void removeTaskId(int taskId);

}
