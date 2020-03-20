package cn.zucc.controller;

import cn.zucc.entity.Department;
import cn.zucc.entity.Employee;
import cn.zucc.service.DepartmentService;
import cn.zucc.service.EmployeeService;
import cn.zucc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取员工列表
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping(value = "/showEmployeeList")
    public String showEmployeeList(Integer pageNo,Integer pageSize, Model model){

        if(pageNo==null){
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=5;
        }

        Page<Employee> employees = employeeService.getEmployeePage(pageNo, pageSize);
        System.out.println(employees);
        model.addAttribute("employees",employees);

        return "employee_list";
    }

    /**
     * 跳转添加员工页面
     */
    @GetMapping("/jumpAddEmployeeEdit")
    public String jumpAddEmployeeEdit(Model model){
        List<Department> departments = departmentService.getDepartmentList();
        model.addAttribute("departments", departments);
        return "employee_add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping(value = "/addEmployee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        System.out.println(employee);
        return "redirect:/showEmployeeList";
      //  return "employee_list";
    }

    /**
     * 删除
     * @param empId
     * @return
     */
    @GetMapping(value = "/deleteEmployeeByEmpId/{empId}")
    public String deleteEmployeeByEmpId(@PathVariable("empId") Integer empId){
        System.out.println(empId);
        employeeService.deleteEmployeeByEmpId(empId);
        return "redirect:/showEmployeeList";
    }
    /**
     * 跳转更新页面
     */
    @GetMapping("/jumpUpdateEmployeeEdit")
    public String jumpUpdateEmployeeEdit(Integer empId, Model model){
        //下拉列表
        List<Department> departments = departmentService.getDepartmentList();
        model.addAttribute("departments",departments);
        //数据回显
        Employee employee = employeeService.getEmployeeByEmpId(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "redirect:/showEmployeeList";
    }

    /**
     * JS获取分页数据
     */
    @ResponseBody
    @GetMapping(value = "/getEmployeePage")
    public Page<Employee> getEmployeePage(Integer pageNo,Integer pageSize){

        System.out.println(pageNo);
        System.out.println(pageSize);

        if(pageNo==null){
            pageNo=1;
        }
        if (pageSize==null){
            pageSize=5;
        }

        return employeeService.getEmployeePage(pageNo, pageSize);
    }

}
