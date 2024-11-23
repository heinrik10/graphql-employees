package br.com.otavio.graphql.service;

import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.otavio.graphql.enums.Gender;
import br.com.otavio.graphql.model.Employee;
import br.com.otavio.graphql.model.Person;

@Service
public class EmployeeService {

    public Map<String, Employee> employees = new HashMap<>();

    public List<Employee> hireEmployee(String name, Integer age, Gender gender, String job, Double salary){
        Employee employee = createEmployee(name, age, gender, job, salary);
        employees.put(employee.getId(), employee);
        return employees.values().stream().toList();
    }

    private Employee createEmployee(String name, Integer age, Gender gender, String job, Double salary){
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setJob(job);
        employee.setFriends(new ArrayList<>());
        employee.setSalary(salary);
        return employee;
    }

    public Employee findEmployeeById(String employeeId){
        return employees.get(employeeId);
    }

    public Employee associateFriend(String myId, String friendId) {
        Employee friend = employees.get(friendId);
        Employee me = employees.get(myId);
        me.getFriends().add(friend);
        friend.getFriends().add(me);
        return me;
    }

    public List<Person> findFriendsById(String employeeId) {
        return employees.get(employeeId).getFriends();
    }
}
