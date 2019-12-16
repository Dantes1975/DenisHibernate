package repozitory;

import beans.Project;

import java.util.List;


public class ProjectDaoImpl extends AbstractDao <Project> implements ProjectDao {
    public final String GET_PROJECTS_WITH_EMPLOYEES_INTERNAL = "select p from Project p left join fetch " +
            "p.employees e where e.external=false";
    public final String GET_PROJECTS_WITH_EMPLOYEES_EXTERNAL = "select p from Project p left join fetch " +
            "p.employees e where e.external=true";

public List<Project> getProjectsWithEmployeesInternal(){
    return getResultListByQuery(GET_PROJECTS_WITH_EMPLOYEES_INTERNAL);
}

    public List<Project> getProjectsWithEmployeesExternal(){
        return getResultListByQuery(GET_PROJECTS_WITH_EMPLOYEES_EXTERNAL);
    }
}
