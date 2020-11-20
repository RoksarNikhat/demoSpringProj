package com.example.demoSpringProj.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {
    @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRST_NAME")
    @ApiModelProperty(value="First name of user",example="Rahul")
    @NotNull(message="First name cannot be empty")
    @Pattern(regexp="^[a-zA-Z]+$",message="First name can only contain alphabets")
    private String firstName;

    @Column(name = "LAST_NAME")
    @ApiModelProperty(value="Last name of user",example="Verma")
    @NotNull(message="Last name cannot be empty")
    @Pattern(regexp="^[a-zA-Z]+$",message="Last name can only contain alphabets")
    private String lastName;

    @ApiModelProperty(value="Email  of user",example="rv@gmail.com")
    @Column(name="EMAIL")
    @NotNull(message="Email  cannot be empty")
    private String email;


}
