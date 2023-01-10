package com.bridgelabz.employee_payroll.repository;

import com.bridgelabz.employee_payroll.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//handles all the CRUD operations
@Repository
                                                    //Modelclass   primary key's datatype
public interface IrepoEmployee extends JpaRepository<EmployeeModel,Integer> {

    //custom query to fetch data based on this
    //here department is used so while declaring and implementing we have to use same variable in service class
    @Query(value = "select * from employee_model where department = :department ",nativeQuery = true)
    List<String> findEmployeeByDepartment(String department);
}
