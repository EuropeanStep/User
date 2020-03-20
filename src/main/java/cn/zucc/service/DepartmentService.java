package cn.zucc.service;

import cn.zucc.entity.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 获取部门列表
     * @return
     */
    List<Department> getDepartmentList();

}
