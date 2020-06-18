package com.empform.interfaces;

import com.empform.model.Employee;

public interface IEmployeeOperation {
    int insertEmployee(Employee e);

    Employee getEmployee(String name, String passwd);

    Employee getEmployee(String emailId);
}
