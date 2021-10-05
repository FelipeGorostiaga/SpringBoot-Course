package com.fgorostiaga.springcourse.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@ApiModel(description = "User object")
@Entity
@Table(name = "users")
public class User {

    /* Use @JsonIgnore so that jackson ignores a property, eg: password field [STATIC FILTERING] */

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "Name should have at least 2 characters")
    @Size(min = 2, max = 50)
    private String name;

    @Past
    @ApiModelProperty(notes = "Birthday should be before current date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public User(Long id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public User(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    protected User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
