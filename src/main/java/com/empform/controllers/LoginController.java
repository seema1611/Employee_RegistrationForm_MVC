package com.empform.controllers;

import com.empform.interfaces.IEmployeeOperation;
import com.empform.model.Employee;
import com.empform.repository.EmployeeOperationImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping(path = "/loginProcess", method = RequestMethod.GET)
    public void showLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("hi");
        IEmployeeOperation ed = new EmployeeOperationImplementation();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        String submit = req.getParameter("submit");

        if (submit.equals("Login")) {
            Employee employee = ed.getEmployee(name, password);
            System.out.println(employee.getName());
            if (employee.getName() != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("name",employee.getName());
                session.setAttribute("emailId",employee.getEmailId());
                session.setAttribute("address",employee.getAddress());
                session.setAttribute("salary",employee.getSalary());
                session.setAttribute("position",employee.getPosition());
                req.getRequestDispatcher("/index").forward(req,res);

            } else {
                req.getRequestDispatcher("/login").include(req, res);
                System.out.println("dispatch");
            }
        }
    }
}

