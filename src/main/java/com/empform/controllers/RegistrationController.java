package com.empform.controllers;
/**
 * purpose:register user with valid details
 */

import com.empform.interfaces.IEmployeeOperation;
import com.empform.model.Employee;
import com.empform.repository.EmployeeOperationImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class RegistrationController {
    static String NAME_PATTERN = "^[A-Z][a-z]{2,}$";
    static String EMAIL_ID = "^[A-Za-z]{3,}([.|+|_|-]?[A-Za-z0-9]+)?[@][A-Za-z0-9]+[.][A-Za-z]{2,4}([.][A-Za-z]{2,4}+)?$";
    static String ADDRESS_PATTERN = "^[A-Z][a-z]{1,}$";
    static String SALARY_PATTERN = "^[0-9]{2,}$";
    static String REGEX_PASSWORD = "^((?=[^@|#|&|%|$]*[@|&|#|%|$][^@|#|&|%|$]*$)(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9#@$?]{8,})$";

    @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
    public void showRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        IEmployeeOperation ed = new EmployeeOperationImplementation();

        String name = req.getParameter("name");
        String emailId = req.getParameter("email");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");
        String position = req.getParameter("position");
        String password = req.getParameter("password");

        String submit=req.getParameter("submit");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmailId(emailId);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setPosition(position);
        employee.setPassword(password);

        System.out.println("values retrieved");
        if (submit.equals("Register")) {

            System.out.println("hi reg");
            boolean nameMatch = name.matches(NAME_PATTERN);
            boolean emailMatch = emailId.matches(EMAIL_ID);
            boolean addressMatch = address.matches(ADDRESS_PATTERN);
            boolean salaryMatch = salary.matches(SALARY_PATTERN);
            boolean positionMatch = position.contains(position);
            boolean passwordMatch = password.matches(REGEX_PASSWORD);

            if (nameMatch && passwordMatch && addressMatch && emailMatch && salaryMatch && positionMatch) {
                System.out.println("req " + req);
                System.out.println("res " + res);

                int result = ed.insertEmployee(employee);
                if (result != 0) {
                    PrintWriter out = res.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Registration successfull...!!!! ');");
                    out.println("</script>");
                    req.getRequestDispatcher("/login").include(req,res);
                }

            } else {
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Invalid details!!! ');");
                out.println("</script>");
                req.getRequestDispatcher("/register").include(req,res);
            }
            System.out.println("terminate");
        }
    }
}