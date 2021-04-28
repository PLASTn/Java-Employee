package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Найти всех сотрудников с заданной фамилией
     */
    public List<Employee> getByLastName(String lastName) {
        List<Employee> findEmployees = new LinkedList<>();
        for(var employee: employees){
            if(employee.getFirstName().equals(lastName)) {
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

    /**
     * Найти всех сотрудников старше заданного возраста
     */
    public List<Employee> getOlderThan(int age) {
        List<Employee> findEmployyes = new LinkedList<>();
        for(var employee: employees){
            if(employee.getYearsOld(employee.getBirthday()) > age){
                findEmployyes.add(employee);
            }
        }
        return findEmployyes;
    }

    /**
     * Найти всех сотрудников заданного пола.
     * Вместо Object используйте ваш класс для пола
     */
    public List<Employee> getByGender(Gender gender) {
        List<Employee> findEmployyes = new LinkedList<>();
        for(var employee: employees){
            if(employee.getGender().equals(gender)){
                findEmployyes.add(employee);
            }
        }
        return findEmployyes;
    }

    /**
     * Найти всех сотрудников с указанными должностями
     */
    public List<Employee> getByStates(String... states) {
        List<Employee> findEmployyes = new LinkedList<>();
        for (var employee: employees){
            for(var state: states){
                if(employee.getPost().equals(state)){
                    findEmployyes.add(employee);
                }
            }
        }
        return findEmployyes;
    }

    /**
     * Найти всех сотрудников с зарплатой меньше заднной в рублях
     */
    public List<Employee> getBySalaryLessThan(BigDecimal salaryInRubbles) { //Здесь был int поправил на BigDecimal
        List<Employee> findEmployees= new LinkedList<>();
        for(var emoloyee: employees){
            if(emoloyee.getSalary().compareTo(salaryInRubbles) == -1){
                findEmployees.add(emoloyee);
            }
        }
        return findEmployees;
    }

    /**
     * Найти всех сотрудников, обладающих заданным навыком
     */
    public List<Employee> getBySkill(String skill) {
        List <Employee> findEmployees= new LinkedList<>();
        for(var employee: employees){
            for (var i: employee.getSkills())
            if(i.equals(skill)){
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

    /**
     * Найти всех сотрудников, работающих в компании больше заданного числа лет
     */
    public List<Employee> getWorkMoreThan(int years) {
        List<Employee> findEmployees = new LinkedList<>();
        for (var employee: employees){
            if(employee.getYearsPost(employee.getDateOfStart()) > years){
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

    /**
     * Найти всех сотрудников, у которых День рождения в указанную дату
     */
    public List<Employee> getBirthDayMates(LocalDate date) {
        List<Employee> findEmployees = new LinkedList<>();
        for (var employee: employees){
            if(employee.getBirthday().getMonth() == date.getMonth() && employee.getBirthday().getDayOfMonth() == date.getDayOfMonth()){
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

    /**
     * Получить сколько всего сотрудников работает в компании
     */
    public int amount() {
        int howMany = 0;
        for (var employee: employees){
            if(employee.getFired() == false){
                howMany++;
            }
        }
        return howMany;
    }

    /**
     * Получить сколько всего денег тратит компания на зарплаты в год.
     * Вместо Object используйте подходящий тип данных
     */
    public BigDecimal totalSalary() {
        BigDecimal all = new BigDecimal(0.00);
        BigDecimal daysOfMonth = new BigDecimal(12.00);
        for(var employee: employees){
            all = all.add(employee.getSalary().multiply(daysOfMonth))  ;
        }
        return all;
    }

    /**
     * Получить отображение идентификатора работника на сущность работника для удобства дальнейшего поиска по id
     */
    public Map<Integer, Employee> mapIdToEmployee() {
        Map<Integer, Employee> idEmployee = new HashMap<>();
        for(var employee: employees){
            idEmployee.put(employee.getId(),employee);
        }
        return idEmployee;
    }
}
