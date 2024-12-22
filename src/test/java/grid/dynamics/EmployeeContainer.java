package grid.dynamics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeContainer {
    @JsonProperty("employees")
    private Employees employees;

    // Accessor method for employees
    public Employees getEmployees() {
        return employees;
    }
}
