package cn.zucc.entity;

import lombok.Data;


import java.util.List;

/**
 * 映射数据库department表
 */
@Data
public class Department {

    private Integer deptId;
    private String deptName;
    //一对多
    private List<Employee> employees;
}
