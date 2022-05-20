package com.interview.h2.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Player {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long parentId;
    private String name;
    private String color;

}
