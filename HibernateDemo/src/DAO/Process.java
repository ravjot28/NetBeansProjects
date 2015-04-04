package DAO;

import DTO.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;

public class Process {

    public void processSave(Employee emp) {
        try {
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            s.save(emp);
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processDelete(int SAPId){
        try{
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            String hql = "delete from Employee emp where SAPId = "+SAPId;
            Query query = s.createQuery(hql);
            query.executeUpdate();
            s.getTransaction().commit();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List processSearchByName(String name){
        try{
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            Criteria criteria = s.createCriteria(Employee.class);
            Expression.eq("EmpName", name);
            return criteria.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void processUpdate(int SAPId,String EmpName,String EmpDOB,String EmpHobbies){
        try{
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            Employee emp = (Employee) s.get(Employee.class, new Integer(SAPId));
            if(EmpName!=null)
                emp.setEmpName(EmpName);
            if(EmpDOB != null)
                emp.setEmpDOB(EmpDOB);
            if(EmpHobbies != null)
                emp.setEmpHobbies(EmpHobbies);
            s.getTransaction().commit();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Employee processSearchByID(int SAPId){
        try{
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            Employee emp = (Employee) s.get(Employee.class, new Integer(SAPId));
            s.getTransaction().commit();
            s.close();
            return emp;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
