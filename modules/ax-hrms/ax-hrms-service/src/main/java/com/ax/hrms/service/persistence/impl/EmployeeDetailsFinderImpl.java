package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.persistence.EmployeeDetailsFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component(service = EmployeeDetailsFinder.class)
public class EmployeeDetailsFinderImpl extends EmployeeDetailsFinderBaseImpl implements EmployeeDetailsFinder {
    @Reference
    private CustomSQL _customSQL;

    public List<Long> getAllontinuedEmployeeIds(){
        List<Long> employeeIds = new ArrayList<>();
        System.out.println("Inside custom sql");
        Session session=null;
        try{
            session=openSession();
            String sql=_customSQL.get(getClass(),"getAllContinuedEmployeeId");
            System.out.println("Query==> "+sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            QueryPos qPos = QueryPos.getInstance(sqlQuery);

            for(Object employeeId: sqlQuery.list()){
                employeeIds.add(Long.valueOf(String.valueOf(employeeId)));
            }
            return employeeIds;
        }catch(Exception e){
            System.out.println("Exception in custom sql ::: getEmployeeIdByNameString ::: "+e.getMessage());
        }finally {
            closeSession(session);
        }
        return employeeIds;
    }
    public List<Long> getEmployeeIdByNameString(String nameStr){
        List<Long> employeeIds = new ArrayList<>();
        System.out.println("Inside custom sql");
        Session session=null;
        try{
            session=openSession();
            String sql=_customSQL.get(getClass(),"findEmployeeByName");
            System.out.println("Query==> "+sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            QueryPos qPos = QueryPos.getInstance(sqlQuery);
            qPos.add(nameStr);
            qPos.add(nameStr);

            for(Object employeeId: sqlQuery.list()){
                employeeIds.add(Long.valueOf(String.valueOf(employeeId)));
            }
            return employeeIds;
        }catch(Exception e){
            System.out.println("Exception in custom sql ::: getEmployeeIdByNameString ::: "+e.getMessage());
        }finally {
            closeSession(session);
        }
        return employeeIds;
    }
    public List<Long> getEmployeeIdByDepartmentId(long departmentId){
        List<Long> employeeIds = new ArrayList<>();
        System.out.println("Inside custom sql");
        Session session=null;
        try{
            session=openSession();
            String sql=_customSQL.get(getClass(),"findEmployeeByDepartmentId");
            System.out.println("Query==> "+sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            QueryPos qPos = QueryPos.getInstance(sqlQuery);
            qPos.add(departmentId);

            for(Object employeeId: sqlQuery.list()){
                employeeIds.add(Long.valueOf(String.valueOf(employeeId)));
            }
            return employeeIds;
        }catch(Exception e){
            System.out.println("Exception in custom sql ::: getEmployeeIdByNameString ::: "+e.getMessage());
        }finally {
            closeSession(session);
        }
        return employeeIds;
    }
    public List<Long> getEmployeeIdByDesignationId(long designationId){
        List<Long> employeeIds = new ArrayList<>();
        System.out.println("Inside custom sql");
        Session session=null;
        try{
            session=openSession();
            String sql=_customSQL.get(getClass(),"findEmployeeByDesignationId");
            System.out.println("Query==> "+sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            QueryPos qPos = QueryPos.getInstance(sqlQuery);
            qPos.add(designationId);

            for(Object employeeId: sqlQuery.list()){
                employeeIds.add(Long.valueOf(String.valueOf(employeeId)));
            }
            return employeeIds;
        }catch(Exception e){
            System.out.println("Exception in custom sql ::: getEmployeeIdByNameString ::: "+e.getMessage());
        }finally {
            closeSession(session);
        }
        return employeeIds;
    }
    public List<Long> getEmployeeIdByDesignationIdAndDepartmentId(long designationId,long departmentId){
        List<Long> employeeIds = new ArrayList<>();
        System.out.println("Inside custom sql");
        Session session=null;
        try{
            session=openSession();
            String sql=_customSQL.get(getClass(),"findEmployeeByDesignationIdAndDepartmentId");
            System.out.println("Query==> "+sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            QueryPos qPos = QueryPos.getInstance(sqlQuery);
            qPos.add(designationId);
            qPos.add(departmentId);

            for(Object employeeId: sqlQuery.list()){
                employeeIds.add(Long.valueOf(String.valueOf(employeeId)));
            }
            return employeeIds;
        }catch(Exception e){
            System.out.println("Exception in custom sql ::: getEmployeeIdByNameString ::: "+e.getMessage());
        }finally {
            closeSession(session);
        }
        return employeeIds;
    }
}
