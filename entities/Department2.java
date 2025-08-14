package entities;

import java.util.ArrayList;
import java.util.List;

public class Department2 {
private String name;
private Integer payDay;
private Address address;
private List<Employee> employees = new ArrayList<>();

public Department2() {
	
}

public Department2(String name, Integer payDay, Address address) {
	this.name = name;
	this.payDay = payDay;
	this.address = address;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getPayDay() {
	return payDay;
}

public void setPayDay(Integer payDay) {
	this.payDay = payDay;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Employee> getEmployee() {
	return employees;
}

public void addEmployee(Employee employee) {
	employees.add(employee);
}

public void removeEmployee(Employee employee) {
	employees.remove(employee);
}
public double payroll() {
    double sum = 0.0;
    for (Employee emp : employees) {
        sum += emp.getSalary();
    }
    return sum;
}
}
