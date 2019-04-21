package com.thoughtworks.nho.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtworks.nho.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private String desc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date startTime;

    public TrainingCamp() {
        id = StringUtils.uuid();
    }
}