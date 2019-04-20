package com.thoughtworks.nho.dto;

import com.thoughtworks.nho.domain.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class TrainingCampDetail {
    String title;
    String desc;
    String startTime;
    List<Task> tasks;
    List<TrainingCampStudent> studentList;

    public TrainingCampDetail(String title, String desc, String startTime, List<Task> tasks, List<TrainingCampStudent> studentList) {
        this.title = title;
        this.desc = desc;
        this.startTime = startTime;
        this.tasks = tasks;
        this.studentList = studentList;
    }
}
