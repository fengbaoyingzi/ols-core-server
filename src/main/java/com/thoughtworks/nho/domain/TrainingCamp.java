package com.thoughtworks.nho.domain;

import com.thoughtworks.nho.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private String desc;

    @Column
    private String startTime;

    public TrainingCamp() {
        id = StringUtils.uuid();
    }
}