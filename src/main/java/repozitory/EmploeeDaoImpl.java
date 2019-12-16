package repozitory;

import beans.Employee;
import beans.Project;
import beans.Unit;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class EmploeeDaoImpl extends AbstractDao<Employee> implements EmploeeDao {
    public Employee getEmployeeByIdWithAll(long id) {
        return getSingleResultByQuery("select e from Employee e left join fetch e.employeePersonalInfo," +
                "e.projects, e.unit where e.id = " + id);
    }


    public void addEmployeeToUnitById(long employeeId, long unitId) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Employee employee = getById(employeeId);
        Unit unit = new UnitDaoImpl().getById(unitId);
        employee.setUnit(unit);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        unit.setEmployees(employees);
        em.merge(employee);
        em.getTransaction().commit();
    }

    public void assignEmployeeForProject(long id, Project project) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Employee employee = getById(id);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        project.setEmployees(employees);
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        employee.setProjects(projects);
        em.merge(employee);
        em.getTransaction().commit();
    }
}
