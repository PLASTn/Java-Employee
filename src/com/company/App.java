package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        TreeSet<String> set1 = new TreeSet<String>();
        set1.add("Artist");
        set1.add("Streamer");
        TreeSet<String> set2 = new TreeSet<String>();
        set2.add("Streamer");
        set2.add("Pranker");
        set2.add("Artist");
        TreeSet<String> set3 = new TreeSet<String>();
        set3.add("Streamer");
        set3.add("Warrior");
        set3.add("Bivis");
        BigDecimal big1 = new BigDecimal(300.00);
        BigDecimal big2 = new BigDecimal(5000.00);
        BigDecimal big3 = new BigDecimal(54000.00);
        List<Employee> employees = List.of(
                new Employee("Saama","Van","Darkholm",LocalDate.of(1972,10,24),
                        LocalDate.of(2007,5,3), Gender.UNDEFINED,"Boss of this gym",set1,big1),

                new Employee("Терентьев", "Антон", "Павлович", LocalDate.of(2000,5,13),
                        LocalDate.of(2019,12,31),Gender.MALE,"Call support",set2,big2),

                new Employee("Жмышенко", "Валерий", "Альбертович", LocalDate.of(1967,4,23),
                        LocalDate.of(1999,7,30),Gender.FEMALE,"Handyman",set3,big3)
        );

        //System.out.println(employees.get(0).toString());
        //System.out.println(employees.get(1).toString());
        //System.out.println(employees.get(2).toString());

        EmployeeRepository employeeRepository = new EmployeeRepository(employees);

        System.out.println(employeeRepository.getByLastName("Терентьев"));
        System.out.println(employeeRepository.getOlderThan(25));
        System.out.println(employeeRepository.getByGender(Gender.MALE));
        System.out.println(employeeRepository.getByStates("Handyman","Boss of this gym"));
        BigDecimal big4 = new BigDecimal(6000);
        System.out.println(employeeRepository.getBySalaryLessThan(big4));
        System.out.println(employeeRepository.getBySkill("Artist"));
        System.out.println(employeeRepository.getWorkMoreThan(11));
        //System.out.println(employees.get(1).getYearsPost(employees.get(1).getDateOfStart()));
        System.out.println(employeeRepository.getBirthDayMates(LocalDate.of(1812, 10, 24)));
        employees.get(1).setFired(true);
        System.out.println(employeeRepository.amount());
        System.out.println(employeeRepository.totalSalary());
        System.out.println(employeeRepository.mapIdToEmployee());
    }
}