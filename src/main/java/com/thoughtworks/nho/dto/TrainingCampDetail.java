package com.thoughtworks.nho.dto;

import com.thoughtworks.nho.domain.Task;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCampDetail {
    String title;
    String desc;
    String startDate;
    List<Task> tasks;
    List<TrainingCampStudent> studentList;

}
