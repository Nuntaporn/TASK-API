package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.Task;

/**
 * The Interface TaskRepository.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
