package com.abd.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name="mytable_id_seq",sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "mytable_id_seq")
    private long id;
    @Column
    private String name;
    @Column
    private long age;

}
