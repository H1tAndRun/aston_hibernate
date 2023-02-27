package ru.aston.dto.department;

public class DepartmentDtoRq {

    private Integer id;

    private String departmentName;

    private String departmentLocation;

    public DepartmentDtoRq() {
    }

    public DepartmentDtoRq(Integer id, String departmentName, String departmentLocation) {
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

    @Override
    public String toString() {
        return "DepartmentDtoRq{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentLocation='" + departmentLocation + '\'' +
                '}';
    }
}
