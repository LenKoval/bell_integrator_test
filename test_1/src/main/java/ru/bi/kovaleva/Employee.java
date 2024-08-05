package ru.bi.kovaleva;

import java.util.Map;

public class Employee {

    private String name;

    private int age;

    private String position;

    private String salary;

    public Employee(Map<String, String> employeeMap) {
        this.name = employeeMap.get("Имя");
        this.age = Integer.parseInt(employeeMap.get("Возраст"));
        this.position = employeeMap.get("Должность");
        this.salary = employeeMap.get("Зарплата");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Сотрудник " +
                "имя: " + name +
                ", age: " + age +
                ", position: " + position +
                ", salary: " + salary;
    }
}
