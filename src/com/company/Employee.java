package com.company;//package com.company;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Employee{
    //уникальный модификатор доступа
    private int id;
    private static int globalId;
    //поле фамилиии
    private final String firstName;
    //пол (мужской,женский)
    private Gender gender;
    //поле имени
    private final String name;
    //поле отчества
    private final String fatherName;
    //дата рождения
    private final LocalDate birthday;
    //дата поступления на работу
    private final LocalDate dateOfStart ;
    //поле способностей рабочего
    private String post;
    private Set <String> skills;
    //поле зарплаты
    private BigDecimal salary;
    //уволен не уволен
    private boolean fired;

    public Employee (String firstName,String name, String fatherName,LocalDate birthday, LocalDate dateOfStart,Gender gender,
                     String post, Set <String> skills, BigDecimal salary) {
        this.firstName = firstName;
        this.name = name;
        this.fatherName = fatherName;
        this.birthday = birthday;
        this.dateOfStart = dateOfStart;
        this.gender = gender;
        this.post = post;
        this.skills = skills;
        this.salary = salary;
        globalId++;//
        this.id = globalId;
    }

    /////////////////get methods/////////////////

    public String getFirstName(){
        return firstName;
    }

    public String getName(){
        return name;
    }

    public String getFatherName(){
        return fatherName;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public LocalDate getDateOfStart(){
        return dateOfStart;
    }

    public Gender getGender(){
        return gender;
    }

    public String getPost(){ return post; }

    public Set<String> getSkills(){
        return skills;
    }

    public BigDecimal getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

    public boolean getFired(){
        return fired;
    }

    ////////////////////////////////////////////
    /////////////set methods///////////////////

    public void setPost(String post){
        this.post = post;
    }

    public void setSkills(String skill){
        skills.add(skill);
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setFired(boolean fired) { this.fired = fired; }

    //////////////////////////////////////////

    public String toString(){
        return "ID: " + id  + "\nFirst name: " + firstName + "\nName: " + name + "\nFather name: " + fatherName + "\nBirthday:" + birthday +
                "\nGender: " + gender + "\nPost: " + post + "\nSkills: " + skills + "\nSalary: " + salary + "\nDate of start: " + dateOfStart
                + "\nFired? " + fired + "\n";
    }

    public boolean equals(Employee employee){
        if((this.id == id) == true){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return id;
    }

    public int getYearsOld(LocalDate birthday){
        LocalDate today = LocalDate.now();
        int yearsOld = today.getYear() - birthday.getYear();
        int daysOld = today.getDayOfYear() - birthday.getDayOfYear();
        if((daysOld) < 0){
            yearsOld--;
        }
        return yearsOld;
    }

    public int getYearsPost(LocalDate dateOfStart){
        int yearsPost = LocalDate.now().getYear() - dateOfStart.getYear();
        int daysPost = LocalDate.now().getDayOfYear() - dateOfStart.getDayOfYear();
        if(daysPost < 0){
            yearsPost--;
        }
        return yearsPost;
    }
}