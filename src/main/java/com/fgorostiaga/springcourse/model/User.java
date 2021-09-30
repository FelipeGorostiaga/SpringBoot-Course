package com.fgorostiaga.springcourse.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@ApiModel(description = "User object")
public class User {

    /* Use @JsonIgnore so that jackson ignores a property, eg: password field [STATIC FILTERING] */

    private Integer id;

    @ApiModelProperty(notes = "Name should have at least 2 characters")
    @Size(min = 2, max = 50)
    private String name;

    @Past
    @ApiModelProperty(notes = "Birthday should be before current date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public User(Integer id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
