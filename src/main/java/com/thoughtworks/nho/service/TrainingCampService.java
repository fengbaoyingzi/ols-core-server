package com.thoughtworks.nho.service;

import com.thoughtworks.nho.domain.TrainingCamp;
import com.thoughtworks.nho.dto.TrainingCampDetail;

import java.util.List;

public interface TrainingCampService {

    TrainingCampDetail getTrainingCampDetailById(String id);

    List<TrainingCamp> findAllTrainingCamp();

    void saveTrainCamp(TrainingCamp trainingCamp);
}
