package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private boolean external;

    @Embedded
    private Address address;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
   // @JoinColumn(name = "PERSONAL_INFO")
    private EmployeePersonalInfo employeePersonalInfo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "EMPLOEE_PROJECTS",
            joinColumns = @JoinColumn(name = "EMPLOEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    protected List<Project> projects = new ArrayList<>();


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_UNIT_ID")
    private Unit unit;

    public Employee(String name, String surname, boolean external) {
        this.name = name;
        this.surname = surname;
        this.external = external;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", external=" + external +
                '}';
    }
}
