package com.example.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.api.model.Task;
import com.example.api.repository.TaskRepository;
import org.springframework.http.ResponseEntity;

/**
 * The Class TaskController.
 */
@RestController
@RequestMapping("/api")
public class TaskController {
	
	/** The task repository. */
	@Autowired
    TaskRepository taskRepository;
	
	/**
	 * Gets the all tasks.
	 * 
	 * Get all tasks list from Database
	 *  
	 * @return the all tasks
	 */
	// Get All Tasks
	@GetMapping("/tasksList")
	public List<Task> getAllTasks() {
	    return taskRepository.findAll();
	}

    /**
     * Creates the task.
     *
     * Add @param task the task to Database
     * 
     * @param task the task
     * @return the task
     */
    // Create a new Task
	@PostMapping("/addTasks")
	public Task createTask(@Valid @RequestBody Task task) {
	    return taskRepository.save(task);
	}

    /**
     * Gets the task by id.
     *
     * @param taskId the task id
     * @return the task by id
     */
    // Get a Single Task
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable(value = "id") Long taskId) {
	    return taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
	}

    /**
     * Update task.
     *
     * @param taskId the task id
     * @param taskDetails the task details
     * @return the task
     */
    // Update a Task
	@PutMapping("/taskUpdate/{id}")
	public Task updateTask(@PathVariable(value = "id") Long taskId,
	                                        @Valid @RequestBody Task taskDetails) {

	    Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	    task.setTaskName(taskDetails.getTaskName());
	    task.setTaskDetail(taskDetails.getTaskDetail());
	    task.setTaskStatus(taskDetails.getTaskStatus());

	    Task updatedTask = taskRepository.save(task);
	    return updatedTask;
	}
	
    /**
     * Sets the task status.
     *
     * @param taskId the task id
     * @param taskDetails the task details
     * @return the task
     */
    // Set a Task Status
	@PutMapping("/taskStatus/{id}")
	public Task setTaskStatus(@PathVariable(value = "id") Long taskId,
	                                        @Valid @RequestBody Task taskDetails) {

	    Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
	    
	    task.setTaskStatus(taskDetails.getTaskStatus());

	    Task updatedTask = taskRepository.save(task);
	    return updatedTask;
	}

    /**
     * Delete task.
     *
     * @param taskId the task id
     * @return the response entity
     */
    // Delete a Task
	@DeleteMapping("/taskDelete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) {
	    Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	    taskRepository.delete(task);

	    return ResponseEntity.ok().build();
	}

}
