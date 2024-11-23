package br.com.otavio.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import br.com.otavio.graphql.enums.Gender;
import br.com.otavio.graphql.model.Employee;
import br.com.otavio.graphql.model.Person;
import br.com.otavio.graphql.service.EmployeeService;

@Controller
public class EmployeeController {

    private EmployeeService service;

    private EmployeeController(EmployeeService service){
        this.service = service;
    }

    @QueryMapping
    public Employee findEmployeeById(@Argument String employeeId){
        return service.findEmployeeById(employeeId);
    }
    
    @MutationMapping
    public List<Employee> hireEmployee(@Argument String name, @Argument Integer age, 
                                       @Argument Gender gender, @Argument String job, 
                                       @Argument Double salary){
        return service.hireEmployee(name, age, gender, job, salary);
    }

    @SchemaMapping(typeName = "Mutation", value = "associateFriend")
    public Employee associateFriendToEmployee(@Argument String myId, @Argument String friendId){
        return service.associateFriend(myId, friendId);
    }
}