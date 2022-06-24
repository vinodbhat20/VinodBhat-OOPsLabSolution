package com.gl.main;

import com.gl.pojo.Employee;
import com.gl.service.CredentialService;

import java.util.Scanner;


public class Main {
    public static final String TECHNICAL = "Technical";
    public static final String ADMIN = "Admin";
    public static final String HR = "Human Resource";
    public static final String LEGAL = "Technical";

    public static void main(String[] args) {
        Employee employee = prepareEmployeeData();

        System.out.println("Please Enter the department from the following");
        System.out.println("1." + TECHNICAL);
        System.out.println("2." + ADMIN);
        System.out.println("3." + HR);
        System.out.println("4." + LEGAL);
        Scanner scanner = new Scanner(System.in);
        int dept = scanner.nextInt();

        updateDepartment(dept, employee);

        CredentialService credentialService = new CredentialService();
        credentialService.generateEmail(employee);
        employee.setPassword(credentialService.generatePassword());
        credentialService.showCredential(employee);

    }

    private static void updateDepartment(int dept, Employee employee) {
        if (employee != null) {
            switch (dept) {
                case 1:
                    employee.setDepartment(TECHNICAL);
                    break;
                case 2:
                    employee.setDepartment(ADMIN);
                    break;
                case 3:
                    employee.setDepartment(HR);
                    break;
                case 4:
                    employee.setDepartment(LEGAL);
                    break;
            }
        }
    }

    private static Employee prepareEmployeeData() {
        Employee employee = new Employee("Vinod", "Bhat");
        employee.setCompany("GL");
        return employee;
    }
}
