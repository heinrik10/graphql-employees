package br.com.otavio.graphql.model;

public class Employee extends Person{
    
    private String job;
    private Double salary;

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double sallary) {
        this.salary = sallary;
    }
}
