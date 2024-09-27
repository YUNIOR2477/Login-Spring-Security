package com.app.controller.dto;

import com.app.entity.User.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private String location;
    private UserEntity user;
}
