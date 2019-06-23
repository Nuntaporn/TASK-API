package com.example.api.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Task.
 */
@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Task {
	
	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** The task name. */
	@NotBlank
	private String taskName;
	
	/** The task detail. */
	@NotBlank
	private String taskDetail;
	
	/** The task status. */
	@NotBlank
	private String taskStatus;
	
	/** The created at. 
	 *  Create Date Create Time 
	 * */
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    /** The updated at. 
     *  Update Date Update Time
     * */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the task detail.
	 *
	 * @return the task detail
	 */
	public String getTaskDetail() {
		return taskDetail;
	}

	/**
	 * Sets the task detail.
	 *
	 * @param taskDetail the new task detail
	 */
	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	/**
	 * Gets the task status.
	 *
	 * @return the task status
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * Sets the task status.
	 *
	 * @param taskStatus the new task status
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the updated at.
	 *
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}	

}
