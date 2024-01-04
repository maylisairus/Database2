package org.example;

import java.sql.Date;

public class Worker {
    private int id;
    private String name;
    private Date birthday;
    private Experience level;
    private int salary;

    public Worker(int id, String name, Date birthday, Experience level, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Experience getLevel() {
        return level;
    }

    public void setLevel(Experience level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", level=" + level +
                ", salary=" + salary +
                '}';
    }
}
