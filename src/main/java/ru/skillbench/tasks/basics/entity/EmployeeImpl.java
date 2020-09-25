package ru.skillbench.tasks.basics.entity;

public class EmployeeImpl implements Employee {
    private int salary;
    private String firstName;
    private String lastName;
    private Employee manager;


    public EmployeeImpl() {
        this.salary = 1000;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void increaseSalary(int value) {
        this.salary += value;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
    this.lastName=lastName;
    }

    @Override
    public String getFullName() {
        return firstName+" "+lastName; //имя + фамилия
    }

    @Override
    public void setManager(Employee manager) {
    this.manager=manager;
    }

    @Override
    public String getManagerName() {
        if(manager!=null) {
            return manager.getFirstName() + " " + manager.getLastName();
        }
        else
            return "No manager";
    }

    @Override
    public Employee getTopManager() {
        if (this.manager==null)
            return  this;
        else
            return this.manager.getTopManager();
    }

}
