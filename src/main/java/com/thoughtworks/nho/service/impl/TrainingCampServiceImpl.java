package com.thoughtworks.nho.service.impl;


import com.thoughtworks.nho.domain.Task;
import com.thoughtworks.nho.domain.TrainingCamp;
import com.thoughtworks.nho.dto.TrainingCampDetail;
import com.thoughtworks.nho.dto.TrainingCampStudent;
import com.thoughtworks.nho.repository.StudentRepository;
import com.thoughtworks.nho.repository.TaskRepository;
import com.thoughtworks.nho.service.TrainingCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainingCampServiceImpl implements TrainingCampService {

    @Autowired
    private com.thoughtworks.nho.repository.TrainingCampRepository trainingCampRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public TrainingCampDetail getTrainingCampDetailById(String id) {
        TrainingCamp trainingCamp = trainingCampRepository.findOne(id);
        List<Task> taskList = taskRepository.findByTrainingCampId(id);
        List<Object[]> objectsList = studentRepository.findStudentList(id);
        List<TrainingCampStudent> studentList = buildTrainingCampStudentListFromObjectList(objectsList);
        return new TrainingCampDetail(trainingCamp.getTitle(), trainingCamp.getDesc(), trainingCamp.getStartDate(), taskList, studentList);
    }

    private List<TrainingCampStudent> buildTrainingCampStudentListFromObjectList(List<Object[]> objectsList){
        List<TrainingCampStudent> trainingCampStudentList = new ArrayList<>();
        for(Object[] objects : objectsList){
            TrainingCampStudent trainingCampStudent = new TrainingCampStudent();
            trainingCampStudent.setName(String.valueOf(objects[0]));
            trainingCampStudent.setEmail(String.valueOf(objects[1]));
            trainingCampStudent.setScore(String.valueOf(objects[2]));
            trainingCampStudentList.add(trainingCampStudent);
        }
        return trainingCampStudentList;
    }

    @Override
    public List<TrainingCamp> findAllTrainingCamp() {
        return trainingCampRepository.findAllByOrderByStartDateDesc();
    }

    @Override
    public void saveTrainCamp(TrainingCamp trainingCamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        trainingCamp.setStartDate(dateString);
        trainingCampRepository.save(trainingCamp);
    }

    @Override
    public void deleteTrainCamp(String id) {
        trainingCampRepository.delete(id);
    }


}
