package org.udg.pds.springtodo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity(name="usergroup")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Group implements Serializable{

    public Group (){

    }

    public Group(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @ManyToOne
    private User owner;
}
