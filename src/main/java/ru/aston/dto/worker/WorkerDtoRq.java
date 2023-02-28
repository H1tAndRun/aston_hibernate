package ru.aston.dto.worker;

public class WorkerDtoRq {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer department_id;

    private Integer role_id;

    public WorkerDtoRq() {
    }

    public WorkerDtoRq(String firstName, String lastName, String email, Integer department_id, Integer role_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department_id = department_id;
        this.role_id = role_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "WorkerDtoRq{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department_id='" + department_id + '\'' +
                ", role_id='" + role_id + '\'' +
                '}';
    }
}
