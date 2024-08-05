package ru.bi.kovaleva;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Map<String, String>> list = List.of(
                Map.of("Имя", "Кирилл", "Возраст", "26", "Должность", "Middle java dev"
                        , "Зарплата", "150000руб"),
                Map.of("Имя", "Виталий", "Возраст", "28", "Должность", "Senior java automation QA"
                        , "Зарплата", "2000$"),
                Map.of("Имя", "Александр", "Возраст", "31", "Должность", "junior funcional tester"
                        , "Зарплата", "50000руб"),
                Map.of("Имя", "Дементий", "Возраст", "35", "Должность", "dev-ops"
                        , "Зарплата", "1500$")
        );

        List<Employee> employeeList = convertData(list);

        System.out.println("Возраст сотрудников < 30 :");
        printNamesUnder30(employeeList);
        System.out.println("_______________________________");
        System.out.println("Средний возраст сотрудников: ");
        System.out.println(getEmployeesAverageAge(employeeList));
        System.out.println("_______________________________");
        System.out.println("Сотрудники с зарплатой в рублях: ");
        printNamesWithSalariesInRubles(employeeList);
        System.out.println("_______________________________");
    }

    private static List<Employee> convertData(List<Map<String, String>> list) {
        return list.stream()
                .map(Employee::new)
                .collect(Collectors.toList());
    }

    private static void printNamesUnder30(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getAge() < 30)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    private static void printNamesWithSalariesInRubles(List<Employee> employees){
        employees.stream().filter(employee -> employee.getSalary().endsWith("руб"))
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    private static Integer getEmployeesAverageAge(List<Employee> employees) {
        return (int) employees.stream().mapToInt(Employee::getAge)
                .average().getAsDouble();
    }
}
