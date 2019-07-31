package com.yash.practice;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

	public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Yash",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Employee employee2 = new Employee(
                "Ram",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Employee employee3 = new Employee(
                "Sita",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
            
            List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
            
            // Get employee with exact match name "Yash", if not found print "Not found".
            Optional<Employee> empNameSearch = 
            		employees.stream().filter(
            				e->e.getName().equals("Yashs")).findAny();
            System.out.println(empNameSearch.isPresent() ? empNameSearch.get() : "NOT FOUND");
            
            // Get employee with matching address "1235"
            Optional<Employee> empAddressSearch = 
            		employees.stream().filter(
            				e->e.getAddress().getZipcode().equals("1235")).findAny();
            System.out.println(empAddressSearch.isPresent() ? empAddressSearch.get() : "NOT FOUND");
            
            // Get all employee having mobile numbers 3333.
            List<Employee> empList = employees.stream()
            		.filter(emp -> emp.getMobileNumbers().stream()
            				.anyMatch(number -> number.getNumber().equals("3333")))
            		.collect(Collectors.toList());
            
            System.out.println(empList);
            
            // Convert List<Employee> to List<String> of employee name
           List<String> empNameList =  employees.stream().map(Employee::getName).collect(Collectors.toList());
           System.out.println(empNameList);
           
            // Collect all the names of employees in a string separated by ||
          String empNamesToString = employees.stream().map(Employee::getName).collect(Collectors.joining("||"));
          System.out.println(empNamesToString);
          
            // Change the case of List<String>
          List<String> empNamesToUpper = empNameList.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
          System.out.println(empNamesToUpper);
          
            // Sort List<String>
          List<String> empSortedByNames = empNameList.stream().sorted().collect(Collectors.toList());
          System.out.println(empSortedByNames);
          
            // sort List<Employee> based on name
          List<Employee> empListSortedByName = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
          System.out.println(empListSortedByName);
            // 
            
            
	}
}
