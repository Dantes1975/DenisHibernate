package repozitory;

import beans.Employee;
import beans.Unit;

public class UnitDaoImpl extends AbstractDao <Unit> implements UnitDao {
    public Unit getUnitByIdWithEmployee(long id) {
        return getSingleResultByQuery("select u from Unit u left join fetch u.employees where u.id = " + id);
    }

}
