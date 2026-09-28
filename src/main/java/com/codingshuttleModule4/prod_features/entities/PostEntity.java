package com.codingshuttleModule4.prod_features.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    //you can implement auditing on your own without using AuditableEntityListeners in this way:-
    /*@PrePersist
    void beforeSave() {

    }

    @PreUpdate
    void beforeUpdate(){

    }

    @PreRemove
    void beforeDelete(){

    }*/
}
