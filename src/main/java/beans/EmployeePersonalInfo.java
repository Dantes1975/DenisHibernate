package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeePersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @OneToOne(mappedBy = "employeePersonalInfo", orphanRemoval = true)
    private Employee employee;

    @Override
    public String toString() {
        return "EmployeePersonalInfo{" +
                "id=" + id +
                ", employeeStatus=" + employeeStatus +
                ", employee=" + employee +
                '}';
    }
}
