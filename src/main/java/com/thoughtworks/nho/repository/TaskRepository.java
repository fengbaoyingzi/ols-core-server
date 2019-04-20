package com.thoughtworks.nho.repository;

import com.thoughtworks.nho.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByTrainingCampId(String TrainingCampId);
}
