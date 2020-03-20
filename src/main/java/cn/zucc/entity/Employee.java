package cn.zucc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 映射数据库employee表
 */
@Data
public class Employee {

    private Integer empId;
    private String empName;
    private String gender;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hireDate;

    //多对一
    private Department department;
}
