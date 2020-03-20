package cn.zucc.service.impl;

import cn.zucc.entity.Employee;
import cn.zucc.mapper.EmployeeMapper;
import cn.zucc.service.EmployeeService;
import cn.zucc.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployeeByEmpId(Integer empId) {
        employeeMapper.deleteEmployeeByEmpId(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public Page<Employee> getEmployeePage(int pageNo, int pageSize) {
        Page<Employee> page = new Page<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Employee> employees = employeeMapper.getEmployeeList();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        page.setPage(pageInfo.getList());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setPageCount(pageInfo.getPages());
        page.setPageNo(pageInfo.getPageNum());
        return page;
    }


    @Override
    public Employee getEmployeeByEmpId(Integer empId) {
        return employeeMapper.getEmployeeByEmpId(empId);
    }
}
