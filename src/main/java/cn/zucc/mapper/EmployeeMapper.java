package cn.zucc.mapper;

import cn.zucc.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库的接口类
 */
@Mapper
public interface EmployeeMapper {


    /**
     * 添加员工
     * @param employee
     */
    void addEmployee(Employee employee);


    /**
     * 删除员工
     */
    void deleteEmployeeByEmpId(Integer empId);


    /**
     * 更新员工
     */
    void updateEmployee(Employee employee);

    /**
     * 查询员工列表
     * @return
     */
    List<Employee> getEmployeeList();

    /**
     * 根据员工ID查询员工信息
     * @param empId
     * @return
     */
    Employee getEmployeeByEmpId(Integer empId);

}
