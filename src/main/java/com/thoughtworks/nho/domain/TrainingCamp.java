package com.thoughtworks.nho.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtworks.nho.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_training_camp")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TrainingCamp {
    @Id
    private String id;

    @Column(unique = true)
    private String title;

    @Column
    private String desc;

    @Column
    private String startDate;

    public TrainingCamp() {
        id = StringUtils.uuid();
    }
}