package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.model.CustomEmployeeDetailsDTO;
import com.liferay.document.library.repository.cmis.Session;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Reference;

//public class SearchInEmployeeFinderImpl extends SearchInEmployeeFinderBaseImpl implements SearchInEmployeeFinder {
//
//    @Reference
//    private CustomSQL customSQL;
//
//    public List<CustomEmployeeDetailsDTO> searchInEmployeeDetails(String firstName, String lastName, String departmentName, String designationName) {
//        Session session = null;
//        try {
//            session = openSession();
//            String sql = customSQL.get(getClass(), "customSqlQueryXmlForSearch");
//            SQLQuery q = session.createSQLQuery(sql);
//            q.setCacheable(false);
//
//            String searchFirstName = "%" + firstName + "%";
//            String searchLastName = "%" + lastName + "%";
//            String departName = "%" + departmentName + "%";
//            String desgiName = "%" + designationName + "%";
//
//            QueryPos qPos = QueryPos.getInstance(q);
//            qPos.add(searchFirstName);
//            qPos.add(searchLastName);
//            qPos.add(departName);
//            qPos.add(desgiName);
//
//            List<Object> resultObjList = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
//
//            List<CustomEmployeeDetailsDTO> employeeDetailsList = new ArrayList<>();
//            for (Object o : resultObjList) {
//                Object[] current = (Object[]) o;
//                CustomEmployeeDetailsDTO employeeDetailsListObj = new CustomEmployeeDetailsDTO();
//                
//                employeeDetailsListObj.setDetailsEmployeeId((long)current[0]);
//                employeeDetailsListObj.setEmployeeCode((String)current[1]);
//                employeeDetailsListObj.setFirstName((String)current[2]);
//                employeeDetailsListObj.setLastName((String)current[3]);
//                employeeDetailsListObj.setOfficialEmail((String) current[4]);
//                employeeDetailsListObj.setPersonalEmail((String)current[5]);
//                employeeDetailsListObj.setJoiningDate((Date)current[6]);
//                employeeDetailsListObj.setLeavingDate((Date)current[7]);
//                employeeDetailsListObj.setMobileNo((String)current[8]);
//                employeeDetailsListObj.setGender((String)current[9]);
//                employeeDetailsListObj.setFatherName((String)current[10]);
//                employeeDetailsListObj.setDateOfBirth((Date)current[11]);
//                employeeDetailsListObj.setMaritalStatus((boolean)current[12]);
//                employeeDetailsListObj.setMarriageDate((Date)current[13]);
//                employeeDetailsListObj.setSpouseName((String)current[14]);
//                employeeDetailsListObj.setEmployeeAddressId((long)current[15]);
//                employeeDetailsListObj.setSkypeId((String)current[16]);
//                employeeDetailsListObj.setNominneeId((long)current[17]);
//                employeeDetailsListObj.setBankAccountId((long)current[18]);
//                employeeDetailsListObj.setUanEsicId((long)current[19]);
//                employeeDetailsListObj.setProbationStatusId((long)current[20]);
//                employeeDetailsListObj.setEmployeeOnboarded((boolean)current[21]);
//                employeeDetailsListObj.setExperienced((boolean)current[22]);
//                employeeDetailsListObj.setProbationEnabled((boolean)current[23]);
//                employeeDetailsListObj.setProfilePicId((long)current[24]);
//                employeeDetailsListObj.setInsuranceLink((String)current[25]);
//                employeeDetailsListObj.setDepartmentEmployeeId((long)current[26]);
//                employeeDetailsListObj.setDepartmentStatus((boolean)current[27]);
//                employeeDetailsListObj.setDepartmentDateOfChange((Date)current[28]);
//                employeeDetailsListObj.setDesignationEmployeeDesignationId((long)current[29]);
//                employeeDetailsListObj.setDesignationStatus((boolean)current[30]);
//                employeeDetailsListObj.setDepartmentDepartmentMasterId((long)current[31]);
//                employeeDetailsListObj.setDepartmentMasterDepartmentName((String)current[32]);
//                employeeDetailsListObj.setDesignationDesignationMasterId((long)current[33]);
//                employeeDetailsListObj.setDesignationMasterDesignationName((String)current[34]);
//                
//                employeeDetailsList.add(employeeDetailsListObj);
//            }
//            return employeeDetailsList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeSession(session);
//        }
//        return null;
//
//    }


//}
