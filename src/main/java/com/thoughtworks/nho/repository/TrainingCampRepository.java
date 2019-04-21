package com.thoughtworks.nho.repository;

import com.thoughtworks.nho.domain.TrainingCamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingCampRepository  extends JpaRepository<TrainingCamp, String> {
    List<TrainingCamp> findAllByOrderByStartDateDesc();
}
