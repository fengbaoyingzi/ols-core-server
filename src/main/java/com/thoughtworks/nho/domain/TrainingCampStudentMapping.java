package com.thoughtworks.nho.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_training_camp_student_mapping")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TrainingCampStudentMapping {
    @Id
    String id;

    @Column
    String trainingCampId;

    @Column
    String studentId;

    @Column
    String studentScore;
}
