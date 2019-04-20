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

@Table(name = "t_student")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Student {
    @Id
    String id;

    @Column
    String name;

    @Column
    String email;

    public Student() {
        id = StringUtils.uuid();
    }
}
