package com.gl.service;

import com.gl.pojo.Employee;

import java.security.SecureRandom;
import java.util.Random;

public class CredentialService {

    public static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_CHARS = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`";

    public String generatePassword() {
        char[] ALL_CHARS = (ALPHA_UPPER + ALPHA_LOWER + NUMBERS + SPECIAL_CHARS).toCharArray();
        Random rand = new SecureRandom();
        int length = 6;
        char[] password = new char[length];

        //get the requirements out of the way
        password[0] = ALPHA_LOWER.toCharArray()[rand.nextInt(ALPHA_UPPER.length())];
        password[1] = ALPHA_UPPER.toCharArray()[rand.nextInt(ALPHA_UPPER.length())];
        password[2] = NUMBERS.toCharArray()[rand.nextInt(NUMBERS.length())];
        password[3] = SPECIAL_CHARS.toCharArray()[rand.nextInt(SPECIAL_CHARS.length())];

        //populate rest of the password with random chars
        for (int i = 4; i < length; i++) {
            password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }

        //shuffle
        for (int i = 0; i < password.length; i++) {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }

        return new String(password);
    }

    public void generateEmail(Employee employee) {
        StringBuffer emailBuf = new StringBuffer(employee.getFirstName())
                .append(employee.getLastName()).append("@")
                .append(employee.getDepartment()).append(".")
                .append(employee.getCompany())
                .append(".com");
        employee.setEmail(emailBuf.toString());
    }

    public void showCredential(Employee employee) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Dear ").append(employee.getFirstName())
                .append(" your generated credentials are as follows\nEmail ---> ")
                .append(employee.getEmail())
                .append("\nPassword ---> " + employee.getPassword());
        System.out.println(buffer);
    }
}
