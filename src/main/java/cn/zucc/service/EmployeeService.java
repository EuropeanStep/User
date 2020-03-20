package cn.zucc.service;


import cn.zucc.entity.Employee;
import cn.zucc.util.Page;

public interface EmployeeService {

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
     * 查询员工列表页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Employee> getEmployeePage(int pageNo, int pageSize);

    /**
     * 根据员工ID查询员工信息
     * @param empId
     * @return
     */
    Employee getEmployeeByEmpId(Integer empId);

}
