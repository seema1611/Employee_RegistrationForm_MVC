package com.empform.repository;

import com.empform.connection.ConnectionProvider;
import com.empform.interfaces.IEmployeeOperation;
import com.empform.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeOperationImplementation implements IEmployeeOperation {
    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertEmployee(Employee e) {
        int status = 0;
        try {
            System.out.println("connection done ");
            Connection con = ConnectionProvider.getCon();
            ps = con.prepareStatement("insert into employee(name,email,address,salary,position,Password,RegisteredDate) values (?,?,?,?,?,?,CURRENT_TIMESTAMP )");

            ps.setString(1, e.getName().trim());
            ps.setString(2, e.getEmailId().toLowerCase());
            ps.setString(3, e.getAddress());
            ps.setString(4, e.getSalary());
            ps.setString(5, e.getPosition());
            ps.setString(6, e.getPassword());

            status = ps.executeUpdate();
            System.out.println(status);
            con.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return status;
    }


    @Override
    public Employee getEmployee(String name, String passwd) {
        Employee e = new Employee();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from employee where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, passwd);
            System.out.println(e);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                e.setName(resultSet.getString(1));
                e.setEmailId(resultSet.getString(2));
                e.setAddress(resultSet.getString(3));
                e.setSalary(resultSet.getString(4));
                e.setPosition(resultSet.getString(5));
                e.setPassword(resultSet.getString(6));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return e;
    }


    @Override
    public Employee getEmployee(String emailId) {
        Employee e = new Employee();

        try {
            con = ConnectionProvider.getCon();

            ps = con.prepareStatement("select  * from employee where EmailId=?");
            ps.setString(1, emailId);
            System.out.println(e);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                e.setEmailId(resultSet.getString(2));
                System.out.println("..................");
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("address"));

                System.out.println("..................");
                e.setEmailId(resultSet.getString(5));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return e;
    }
}

