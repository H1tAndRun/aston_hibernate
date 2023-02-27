package ru.aston.dto.department;

public class DepartmentDtoRs {

    private Integer id;

    private String departmentName;

    private String departmentLocation;

    public DepartmentDtoRs(Integer id, String departmentName, String departmentLocation) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
}
