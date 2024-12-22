package grid.dynamics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Employees {
    @JsonProperty("employee")
    private List<Employee> employee;

    // Accessor method for the employee list
    public List<Employee> getEmployee() {
        return employee;
    }
}
