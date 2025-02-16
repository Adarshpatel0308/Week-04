package org.example.mapinterface.groupobjects_by_property;

import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class GroupObjects {
        public static void main(String[] args) {
            // Create sample employees
            List<Employee> employees = Arrays.asList(
                    new Employee("Alice", "HR"),
                    new Employee("Bob", "IT"),
                    new Employee("Carol", "HR")
            );

            // Create a map to group employees by department
            Map<String, List<Employee>> groupedEmployees = new HashMap<>();

            // Group employees by department
            for (Employee emp : employees) {
                String department = emp.department;
                if (!groupedEmployees.containsKey(department)) {
                    groupedEmployees.put(department, new ArrayList<>());
                }
                groupedEmployees.get(department).add(emp);
            }

            // Print the result
            for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
