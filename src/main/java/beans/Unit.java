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
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String unitname;

    public Unit(String unitname) {
        this.unitname=unitname;
    }

    @OneToMany(mappedBy = "unit", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList();

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", unitname='" + unitname + '\'' +
                ", employees=" + employees +
                '}';
    }
}
