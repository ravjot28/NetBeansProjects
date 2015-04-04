package com.rvp.dao;

import com.rvp.dto.InsuranceDTO;
import com.rvp.dto.SearchDTO;
import com.rvp.dto.StaffDetailsDTO;
import com.rvp.entity.Branches;
import com.rvp.entity.Customer;
import com.rvp.entity.CustomerDetails;
import com.rvp.entity.Insurance;
import com.rvp.entity.InsuranceApplicationDetails;
import com.rvp.entity.InsuranceDetail;
import com.rvp.entity.ProductDetail;
import com.rvp.exception.NoBranchNamesFoundException;
import com.rvp.exception.NoCompanyNamesFoundException;
import com.rvp.exception.NoSchemeNamesFoundException;
import com.rvp.util.Utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class InsuranceDAO {

    public boolean processNewEntry(InsuranceDTO dto) {
        boolean result = false;
        if (!isRecordPresent(dto.getAckNo())) {
            try {
                Session session = Utils.getSessionFactory().getCurrentSession();
                session.beginTransaction();

                Insurance insurance = new Insurance();
                InsuranceDetail insuranceDetail = new InsuranceDetail();
                InsuranceApplicationDetails iad = new InsuranceApplicationDetails();

                Query query = session.createSQLQuery(
                        "select * from branches s where s.branchName = :name").addEntity(Branches.class).setParameter("name", dto.getBranchName());

                System.out.println("Searching");

                Branches branch = (Branches) query.list().get(0);
                System.out.println(branch.getBranchName());
                insurance.setBranchId(branch.getBranchId());
                insurance.setStatus("ACTIVE");
                insurance.setUserId(dto.getUserId());
                insurance.setAckDate(dto.getAckDate());
                insurance.setAckNo(dto.getAckNo());
                insurance.setAppNo(dto.getAppNo());


                insuranceDetail.setBrAss(dto.getStaffDetails().getBranchAsst());
                insuranceDetail.setBrManager(dto.getStaffDetails().getBankMgr());
                insuranceDetail.setInsurance(insurance);
                insuranceDetail.setStaffId(dto.getStaffDetails().getStaffCode());

                System.out.println("Creating customer");
                Customer customer = new Customer();
                customer.setActive('Y');
                customer.setCustomerCity(dto.getCity());
                customer.setCustomerDOB(dto.getDob());
                customer.setCustomerEmailId(dto.getEmailId());
                customer.setCustomerGender(dto.getGender());
                customer.setCustomerMaritalStatus(dto.getMaritalStatus());
                customer.setCustomerMobileNo(dto.getMobileNo());
                customer.setCustomerName(dto.getDepositorName());
                customer.setCustomerNomineeName(dto.getNomineeName());
                customer.setCustomerPhoneNo(dto.getPhNumber());
                customer.setCustomerPinCode(dto.getPinCode());
                customer.setCustomerResidentStatus(dto.getResidentialStatus());
                customer.setCustomeraddress(dto.getAddress());

                session.save(customer);

                CustomerDetails customerDetail = new CustomerDetails();
                customerDetail.setCustomerAddressProof(dto.getAddressProof());
                customerDetail.setCustomerAgeProof(dto.getAgeProof());
                customerDetail.setCustomerBankBranch(dto.getBankBranch());
                customerDetail.setCustomerChequeDate(dto.getPremCheqDate());
                customerDetail.setCustomerChequeNumber(dto.getPremCheqNum());
                customerDetail.setCustomerId(customer.getCustomerId());
                customerDetail.setCustomerIdProof(dto.getIdProof());
                customerDetail.setCustomerIncomeProof(dto.getIncomeProof());
                customerDetail.setCustomerPanNo(dto.getPanNumber());
                customerDetail.setCustomerBankName(dto.getBankName());

                session.save(customerDetail);

                iad.setBankMicrNo(dto.getMicrNo());
                iad.setCustomerDetailId(customerDetail.getCustomerDetailsId());
                iad.setCustomerId(customer.getCustomerId());
                iad.setEcsGiven(dto.getEcsGiven());
                iad.setExistsPolicyNo(dto.getExistPolicyNo());
                iad.setInsuraceDetail(insuranceDetail);
                iad.setLifeAssured(dto.getLifeAssured());
                iad.setPayMode(dto.getPaymentMode());
                iad.setPolictAmt(dto.getPolicyAmt());
                iad.setPolicyTerm(dto.getPolicyTerm());
                iad.setPremiumAmt(dto.getPremiumAmt());
                iad.setPremCheqAmt(dto.getPremCheqAmt());
                Criteria criteria = session.createCriteria(ProductDetail.class);
                criteria.add(Expression.eq("companyName", dto.getCompanyName().trim()));
                criteria.add(Expression.eq("schemeName", dto.getSchemeName().trim()));
                ProductDetail productdetails = (ProductDetail) criteria.list().get(0);
                iad.setProductId(productdetails.getProductDetailId());
                iad.setServiceTax(dto.getServiceTax());

                session.save(iad);
                session.getTransaction().commit();

                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            result = processUpdateRecord(dto);
        }
        return result;
    }

    public boolean processUpdateRecord(InsuranceDTO dto) {
        boolean status = false;
        List result = null;
        try {
            Session session = Utils.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query query = session.createSQLQuery(
                    "select * from branches s where s.branchName = :name").addEntity(Branches.class).setParameter("name", dto.getBranchName());

            System.out.println("Searching");

            Branches branch = (Branches) query.list().get(0);
            System.out.println(branch.getBranchName());

            query = session.createSQLQuery(
                    "select * from insurance s where s.appNo = :id").addEntity(Insurance.class).setParameter("id", dto.getAppNo());
            result = query.list();
            Insurance insurance = (Insurance) result.get(0);
            insurance.setBranchId(branch.getBranchId());
            insurance.setStatus("ACTIVE");
            insurance.setUserId(dto.getUserId());
            insurance.setAckDate(dto.getAckDate());
            insurance.setAckNo(dto.getAckNo());
            insurance.setAppNo(dto.getAppNo());

            session.update(insurance);

            query = session.createSQLQuery(
                    "select * from insuraceDetail s where s.insuranceId = :id").addEntity(InsuranceDetail.class).setParameter("id", insurance.getInsuranceId());
            result = query.list();
            InsuranceDetail insuranceDetail = (InsuranceDetail) result.get(0);
            insuranceDetail.setBrAss(dto.getStaffDetails().getBranchAsst());
            insuranceDetail.setBrManager(dto.getStaffDetails().getBankMgr());
            insuranceDetail.setStaffId(dto.getStaffDetails().getStaffCode());
            session.update(insuranceDetail);

            query = session.createSQLQuery(
                    "select * from insuranceApplicationDetails s where s.insuranceDetailId = :id").addEntity(InsuranceApplicationDetails.class).setParameter("id", insuranceDetail.getInsuranceDetailId());
            result = query.list();

            InsuranceApplicationDetails iad = (InsuranceApplicationDetails) result.get(0);

            iad.setBankMicrNo(dto.getMicrNo());
            //iad.setCustomerDetailId(customerDetail.getCustomerDetailsId());
            //iad.setCustomerId(customer.getCustomerId());
            iad.setEcsGiven(dto.getEcsGiven());
            iad.setExistsPolicyNo(dto.getExistPolicyNo());
            iad.setInsuraceDetail(insuranceDetail);
            iad.setLifeAssured(dto.getLifeAssured());
            iad.setPayMode(dto.getPaymentMode());
            iad.setPolictAmt(dto.getPolicyAmt());
            iad.setPolicyTerm(dto.getPolicyTerm());
            iad.setPremiumAmt(dto.getPremiumAmt());
            iad.setPremCheqAmt(dto.getPremCheqAmt());
            Criteria criteria = session.createCriteria(ProductDetail.class);
            criteria.add(Expression.eq("companyName", dto.getCompanyName().trim()));
            criteria.add(Expression.eq("schemeName", dto.getSchemeName().trim()));
            ProductDetail productdetails = (ProductDetail) criteria.list().get(0);
            iad.setProductId(productdetails.getProductDetailId());
            iad.setServiceTax(dto.getServiceTax());

            session.update(iad);

            query = session.createSQLQuery(
                    "select * from customer_details s where s.customerdetailsid = :id").addEntity(CustomerDetails.class).setParameter("id", iad.getCustomerDetailId());
            result = query.list();

            CustomerDetails custDetail = (CustomerDetails) result.get(0);
            custDetail.setCustomerAddressProof(dto.getAddressProof());
            custDetail.setCustomerAgeProof(dto.getAgeProof());
            custDetail.setCustomerBankBranch(dto.getBankBranch());
            custDetail.setCustomerChequeDate(dto.getPremCheqDate());
            custDetail.setCustomerChequeNumber(dto.getPremCheqNum());
            //custDetail.setCustomerId(customer.getCustomerId());
            custDetail.setCustomerIdProof(dto.getIdProof());
            custDetail.setCustomerIncomeProof(dto.getIncomeProof());
            custDetail.setCustomerPanNo(dto.getPanNumber());

            session.update(custDetail);
            query = session.createSQLQuery(
                    "select * from customer_info s where s.customerid = :id").addEntity(Customer.class).setParameter("id", iad.getCustomerId());
            result = query.list();

            Customer customer = (Customer) result.get(0);
            customer.setActive('Y');
            customer.setCustomerCity(dto.getCity());
            customer.setCustomerDOB(dto.getDob());
            customer.setCustomerEmailId(dto.getEmailId());
            customer.setCustomerGender(dto.getGender());
            customer.setCustomerMaritalStatus(dto.getMaritalStatus());
            customer.setCustomerMobileNo(dto.getMobileNo());
            customer.setCustomerName(dto.getDepositorName());
            customer.setCustomerNomineeName(dto.getNomineeName());
            customer.setCustomerPhoneNo(dto.getPhNumber());
            customer.setCustomerPinCode(dto.getPinCode());
            customer.setCustomerResidentStatus(dto.getResidentialStatus());
            customer.setCustomeraddress(dto.getAddress());

            session.update(customer);
            session.getTransaction().commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String[] getCompanyNames() throws NoCompanyNamesFoundException {
        String company[] = null;
        try {
            Session session = Utils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from productDetails s where s.productType = :type").addEntity(ProductDetail.class).setParameter("type", "Insurance");
            List<ProductDetail> result = query.list();
            company = new String[result.size() + 1];
            company[0] = "Select Company";
            for (int i = 1; i < result.size() + 1; i++) {
                company[i] = result.get(i - 1).getCompanyName();
            }

            session.getTransaction().commit();
            if (company.length <= 1) {
                throw new NoBranchNamesFoundException();
            }
        } catch (Exception e) {
            throw new NoCompanyNamesFoundException();
        }
        return company;
    }

    public String[] getSchemeNames() throws NoSchemeNamesFoundException {
        String schemes[] = null;
        try {
            Session session = Utils.getSessionFactory().getCurrentSession();

            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from productDetails s where s.productType = :type").addEntity(ProductDetail.class).setParameter("type", "Insurance");
            List<ProductDetail> result = query.list();
            schemes = new String[result.size() + 1];
            schemes[0] = "Select Scheme";
            for (int i = 1; i < result.size() + 1; i++) {
                schemes[i] = result.get(i - 1).getSchemeName();
            }

            session.getTransaction().commit();
            if (schemes.length <= 1) {
                throw new NoBranchNamesFoundException();
            }
        } catch (Exception e) {
            throw new NoSchemeNamesFoundException();
        }
        return schemes;
    }

    public String[] getBranchName() throws NoBranchNamesFoundException {
        String schemes[] = null;
        try {
            Session session = Utils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from branches s").addEntity(Branches.class);
            List<Branches> result = query.list();
            schemes = new String[result.size() + 1];
            schemes[0] = "Select Branch";
            for (int i = 1; i < result.size() + 1; i++) {
                schemes[i] = result.get(i - 1).getBranchName();
            }

            session.getTransaction().commit();
            if (schemes.length <= 1) {
                throw new NoBranchNamesFoundException();
            }
        } catch (Exception e) {
            throw new NoBranchNamesFoundException();
        }
        return schemes;
    }

    public boolean isRecordPresent(String ackNo) {
        boolean present = false;
        List result = null;
        Session session = Utils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(
                "select * from insurance s where s.ackNo = :id").addEntity(Insurance.class).setParameter("id", ackNo);
        result = query.list();
        if (result.size() == 1) {
            present = true;
        }
        session.getTransaction().commit();
        return present;
    }

    public InsuranceDTO editEntrySearch(String ackNo, String appNo) {
        InsuranceDTO dto = null;
        List result = null;
        Session session = Utils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        if (ackNo == null || ackNo.trim().length() == 0) {

            Query query = session.createSQLQuery(
                    "select * from insurance s where s.appNo = :id").addEntity(Insurance.class).setParameter("id", appNo);
            result = query.list();
        } else if (appNo == null || appNo.trim().length() == 0) {
            Query query = session.createSQLQuery(
                    "select * from insurance s where s.ackNo = :id").addEntity(Insurance.class).setParameter("id", ackNo);
            result = query.list();
        } else {
            Query query = session.createSQLQuery(
                    "select * from insurance s where s.ackNo = :id and s.appNo = :id1").addEntity(Insurance.class).setParameter("id", ackNo).setParameter("id1", appNo);
            result = query.list();
        }

        if (result.size() == 1) {
            System.out.println("Found");
            Insurance i = (Insurance) result.get(0);
            dto = new InsuranceDTO();
            dto.setAckDate(i.getAckDate());
            dto.setAckNo(i.getAckNo());
            dto.setAppNo(i.getAppNo());


            Query query = session.createSQLQuery(
                    "select * from insuraceDetail s where s.insuranceId = :id").addEntity(InsuranceDetail.class).setParameter("id", i.getInsuranceId());
            result = query.list();

            InsuranceDetail insuranceDetail = (InsuranceDetail) result.get(0);
            StaffDetailsDTO staffdto = new StaffDetailsDTO();
            staffdto.setBankMgr(insuranceDetail.getBrManager());
            staffdto.setBranchAsst(insuranceDetail.getBrAss());
            staffdto.setStaffCode(insuranceDetail.getStaffId());
            dto.setStaffDetails(staffdto);


            query = session.createSQLQuery(
                    "select * from insuranceApplicationDetails s where s.insuranceDetailId = :id").addEntity(InsuranceApplicationDetails.class).setParameter("id", insuranceDetail.getInsuranceDetailId());
            result = query.list();

            InsuranceApplicationDetails iad = (InsuranceApplicationDetails) result.get(0);

            dto.setMicrNo(iad.getBankMicrNo());
            dto.setEcsGiven(iad.getEcsGiven());
            dto.setExistPolicyNo(iad.getExistsPolicyNo());
            iad.getInsuraceDetail();
            iad.getInsuranceApplicationDetailId();
            dto.setLifeAssured(iad.getLifeAssured());
            dto.setPaymentMode(iad.getPayMode());
            dto.setPolicyAmt(iad.getPolictAmt());
            dto.setPolicyTerm(iad.getPolicyTerm());
            dto.setPremiumAmt(iad.getPremiumAmt());
            dto.setPremCheqAmt(iad.getPremCheqAmt());
            iad.getProductId();
            dto.setServiceTax(iad.getServiceTax());

            System.out.println(iad.getCustomerDetailId());
            query = session.createSQLQuery(
                    "select * from customer_details s where s.customerdetailsid = :id").addEntity(CustomerDetails.class).setParameter("id", iad.getCustomerDetailId());
            result = query.list();

            CustomerDetails custDetail = (CustomerDetails) result.get(0);

            dto.setAddressProof(custDetail.getCustomerAddressProof());
            dto.setAgeProof(custDetail.getCustomerAgeProof());
            dto.setBankBranch(custDetail.getCustomerBankBranch());
            dto.setBankName(custDetail.getCustomerBankName());
            dto.setPremCheqDate(custDetail.getCustomerChequeDate());
            dto.setPremCheqNum(custDetail.getCustomerChequeNumber());
            dto.setIdProof(custDetail.getCustomerIdProof());
            dto.setIncomeProof(custDetail.getCustomerIncomeProof());
            dto.setPanNumber(custDetail.getCustomerPanNo());


            System.out.println(iad.getCustomerId());
            query = session.createSQLQuery(
                    "select * from customer_info s where s.customerid = :id").addEntity(Customer.class).setParameter("id", iad.getCustomerId());
            result = query.list();

            Customer cust = (Customer) result.get(0);

            dto.setCity(cust.getCustomerCity());
            dto.setDob(cust.getCustomerDOB());
            System.out.println(dto.getDob().toString());
            dto.setEmailId(cust.getCustomerEmailId());
            dto.setGender(cust.getCustomerGender());
            dto.setMaritalStatus(cust.getCustomerMaritalStatus());
            dto.setMobileNo(cust.getCustomerMobileNo());
            dto.setDepositorName(cust.getCustomerName());
            dto.setNomineeName(cust.getCustomerNomineeName());
            dto.setPhNumber(cust.getCustomerPhoneNo());
            dto.setPinCode(cust.getCustomerPinCode());
            dto.setResidentialStatus(cust.getCustomerResidentStatus());
            dto.setAddress(cust.getCustomeraddress());

        } else {
            System.out.println("Not Found");
        }
        session.getTransaction().commit();
        return dto;
    }

    public SearchDTO searchResults(SearchDTO dto) throws ParseException, Exception {

        List<String> ackNos = new ArrayList<String>();
        String ackdateFrom = dto.getAckDateFrom();
        String ackdateTo = dto.getAckDateTo();
        String ackNo = dto.getAckNo();
        String appNo = dto.getAppNo();
        List<InsuranceDTO> dtos = new ArrayList<InsuranceDTO>();

        String chequeNo = dto.getCheckNo();

        String policyNo = dto.getPolicyNo();


        String depositorName = dto.getDepositorName();
        String dob1 = dto.getDob();
        java.util.Date sqlDate = null;
        java.util.Date sqlDate1 = null;
        java.util.Date sqlDate2 = null;
        DateFormat userDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (dob1 != null && dob1.trim().length() != 0) {
                sqlDate = userDateFormat.parse(dob1);
            }
            if (ackdateFrom != null && ackdateFrom.trim().length() != 0) {
                sqlDate1 = userDateFormat.parse(ackdateFrom);
            }
            if (ackdateTo != null && ackdateTo.trim().length() != 0) {
                sqlDate2 = userDateFormat.parse(ackdateTo);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Please select correct date for DOB", "Error", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
        String emailId = dto.getEmailId();

        Query query;

        List result;

        Session session = Utils.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Criteria crit = session.createCriteria(Customer.class);
        Criterion nameRestriction = Restrictions.eq("customerName", depositorName);
        Criterion emailIdRestriction = Restrictions.eq("customerEmailId", emailId);
        Criterion dobRestriction = Restrictions.eq("customerDOB", sqlDate);
        LogicalExpression orExp = Restrictions.or(nameRestriction, emailIdRestriction);
        LogicalExpression orExp1 = Restrictions.or(orExp, dobRestriction);
        crit.add(orExp1);
        result = crit.list();

        for (Object cust1 : result) {
            Customer cust = (Customer) cust1;
            int cutsId = cust.getCustomerId();

            query = session.createSQLQuery(
                    "select * from insuranceapplicationdetails s where s.customerid = :id").addEntity(InsuranceApplicationDetails.class).setParameter("id", cutsId);
            result = query.list();

            for (Object details : result) {
                InsuranceApplicationDetails iad = (InsuranceApplicationDetails) details;

                String ackNoTemp = iad.getInsuraceDetail().getInsurance().getAckNo();

                ackNos.add(ackNoTemp);
            }
        }


        crit = session.createCriteria(Insurance.class);
        Criterion ackNoRestriction = Restrictions.eq("ackNo", ackNo);
        Criterion appNoRestriction = Restrictions.eq("appNo", appNo);
        Criterion ackDateFromRestriction = Restrictions.ge("ackDate", sqlDate1);
        Criterion ackDateToRestriction = Restrictions.le("ackDate", sqlDate2);
        Criterion ackDateRestriction = Restrictions.or(ackDateFromRestriction, ackDateToRestriction);
        orExp = Restrictions.or(appNoRestriction, ackDateRestriction);
        orExp1 = Restrictions.or(orExp, ackNoRestriction);
        crit.add(orExp1);
        result = crit.list();

        for (Object ins : result) {
            String ackNoTemp = ((Insurance) ins).getAckNo();
            ackNos.add(ackNoTemp);
        }


        crit = session.createCriteria(CustomerDetails.class);
        Criterion chqNoRestriction = Restrictions.eq("customerChequeNumber", chequeNo);
        crit.add(chqNoRestriction);
        result = crit.list();

        for (Object ins : result) {
            int cutsId = ((CustomerDetails) ins).getCustomerId();
            query = session.createSQLQuery(
                    "select * from insuranceapplicationdetails s where s.customerid = :id").addEntity(InsuranceApplicationDetails.class).setParameter("id", cutsId);
            result = query.list();

            for (Object details : result) {
                InsuranceApplicationDetails iad = (InsuranceApplicationDetails) details;

                String ackNoTemp = iad.getInsuraceDetail().getInsurance().getAckNo();

                ackNos.add(ackNoTemp);
            }
        }

        crit = session.createCriteria(InsuranceApplicationDetails.class);
        Criterion policyNoRestriction = Restrictions.eq("existsPolicyNo", policyNo);
        crit.add(policyNoRestriction);
        result = crit.list();

        for (Object ins : result) {

            InsuranceApplicationDetails iad = (InsuranceApplicationDetails) ins;

            String ackNoTemp = iad.getInsuraceDetail().getInsurance().getAckNo();

            ackNos.add(ackNoTemp);

        }

        for (String ack : ackNos) {
            dtos.add(this.editEntrySearch(ack, null));
        }
        if(ackNos== null || ackNos.size()==0)
            throw new Exception();
        dto.setDto(dtos);


        //session.getTransaction().commit();


        //policyNo in insurance application details table

        //chequeNo in customer_details table
        //appno, ackno, ackdate in insurance table
        //depositorName,emailID, and dob in customer_info table
        return dto;
    }
}
