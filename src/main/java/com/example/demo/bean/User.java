package com.example.demo.bean;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;


    @Size(min = 2, message = "Name은 2글자 이상입니다")
    private String name;

    @Size(message = "등록일은 미래날짜입력 안됩니다")
    private Date joinDate;
}
