import beans.*;
import repozitory.EmploeeDaoImpl;
import repozitory.ProjectDaoImpl;
import repozitory.UnitDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class Runer {

    public static void main(String[] args) {


        EmploeeDaoImpl emploeeDao = new EmploeeDaoImpl();
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        UnitDaoImpl unitDao = new UnitDaoImpl();


        Employee employee = new Employee("Denis", "Rumyancev", true);
        Employee employee1 = new Employee("Alrksandr", "Litvinchuk", false);
        Address address1 = new Address("Zhlobin", "Sovetskaya", 246);
        Address address2 = new Address("Gomel", "Dvornikova", 40);
        employee.setAddress(address1);
        employee1.setAddress(address2);


        EmployeePersonalInfo employeePersonalInfo = new EmployeePersonalInfo();
        employeePersonalInfo.setEmployeeStatus(EmployeeStatus.EMPLOE);
        employeePersonalInfo.setEmployee(employee);
        employee.setEmployeePersonalInfo(employeePersonalInfo);

        EmployeePersonalInfo employeePersonalInfo1 = new EmployeePersonalInfo();
        employeePersonalInfo1.setEmployeeStatus(EmployeeStatus.EMPLOE);
        employeePersonalInfo1.setEmployee(employee1);
        employee1.setEmployeePersonalInfo(employeePersonalInfo1);

        Project project = new Project("String1");
        Project project1 = new Project("JavaEE1");

        List<Project> projects = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        projects.add(project);
        employees.add(employee);

        employee.setProjects(projects);
        project.setEmployees(employees);


        emploeeDao.save(employee);
        emploeeDao.save(employee1);


        Unit unit1 = new Unit("One");
        Unit unit2 = new Unit("Two");
        Unit unit3 = new Unit("Five");

        unitDao.save(unit1);
        unitDao.save(unit2);
        unitDao.save(unit3);

        emploeeDao.addEmployeeToUnitById(1, 1);
        emploeeDao.addEmployeeToUnitById(2, 2);

        emploeeDao.assignEmployeeForProject(1, project1);
        emploeeDao.assignEmployeeForProject(2, project1);


        List<Project> projects2 = projectDao.getProjectsWithEmployeesInternal();
        List<Project> projects1 = projectDao.getProjectsWithEmployeesExternal();
        for (Project p : projects2) {
            System.out.println(p.getProjectName());
        }

        for (Project p : projects1) {
            System.out.println(p.getProjectName());
        }
        emploeeDao.delete(1);
    }
}
