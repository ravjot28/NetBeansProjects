package DAO;

import DTO.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Process {

    public boolean updateUdhaar(String name, String name1, String value) {
        try {
            int val = Integer.parseInt(value);
            try {
                SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                Session s = session.openSession();
                s.beginTransaction();
                Flat f = (Flat) s.get(Flat.class, name);
                if (name1.equalsIgnoreCase("mukul")) {
                    if (f.getBalMukul() == null) {
                        f.setBalMukul("" + val);
                    } else {
                        f.setBalMukul(f.getBalMukul() + val);
                    }
                } else if (name1.equalsIgnoreCase("puneet")) {
                    if (f.getBalPuneet() == null) {
                        f.setBalPuneet("" + val);
                    } else {
                        f.setBalPuneet(f.getBalPuneet() + val);
                    }
                } else if (name1.equalsIgnoreCase("pankaj")) {
                    if (f.getBalPankaj() == null) {
                        f.setBalPankaj("" + val);
                    } else {
                        f.setBalPankaj(f.getBalPankaj() + val);
                    }
                } else if (name1.equalsIgnoreCase("vijay")) {
                    if (f.getBalVijay() == null) {
                        f.setBalVijay("" + val);
                    } else {
                        f.setBalVijay(f.getBalVijay() + val);
                    }
                } else {
                    return false;
                }
                
                s.beginTransaction().commit();
                s.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean check(String name, String password) {
        try {
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            if (password.equals(((Flat) s.get(Flat.class, name)).getPassword())) {
                return true;
            }
            s.getTransaction().commit();
            s.close();
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void createUser(Flat flat) {
        try {
            SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session s = session.openSession();
            s.beginTransaction();
            s.save(flat);
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
        }
    }
}
