package services;

import org.hibernate.Session;
import sql.HibernateUtil;
import sql.entityes.Degree;
import sql.entityes.Departments;
import sql.entityes.Lectors;
import java.util.List;

public class University
{
    private static String comandSeparator="---------------------------------------------------------------------------------------------------------------------------------------------";
    public static void showDepartaments(){
        List<Departments> departments;
        List<Degree> degrees;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            departments = session.createQuery("from Departments ").list();
            degrees= session.createQuery("from Degree ").list();
            System.out.println(comandSeparator);
            for(Departments department:departments){
                for(Degree degree:degrees){
                    long count=department.getDepartamentLectors().stream().filter(i->i.getDegree().getId_degree()==degree.getId_degree()).count();
                    System.out.println(department.getDepartmentName()+" -  "+degree.getDegreeName()+" - "+count);
                }
            }
            System.out.println(comandSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           // HibernateUtil.closeSession(session);
        }
    }
    public static void showHeadDepartament(String head){
        List<Lectors> resultList;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            resultList = session.createQuery("from Lectors where department.departmentName like '"+head+"' and headOfDepartmentName=1").list();
            System.out.println(comandSeparator);
            resultList.stream().forEach(System.out::println);
            System.out.println(comandSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    public static void showaAverageSalary(String head) {
        List<Lectors> resultList;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            long sum=0;
            resultList = session.createQuery("from Lectors where department.departmentName='"+head+"'").list();
            for (Lectors lectors: resultList) {
                sum+=lectors.getSalary();
            }
            long averageSalary=sum/resultList.stream().count();
            System.out.println(comandSeparator);
            System.out.println("Avarage salary of "+head+" = "+averageSalary);
            System.out.println(comandSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    public static void showCountEmployee(String head){
        List<Lectors> resultList;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            resultList = session.createQuery("from Lectors where department.departmentName='"+head+"'").list();
            long employees=resultList.stream().count();
            System.out.println(comandSeparator);
            System.out.println("Count employees in "+head+" = "+employees);
            System.out.println(comandSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    public static void search(String head) {
        List<Lectors> resultList;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            long sum=0;
            resultList = session.createQuery("from Lectors where lector_name like '%"+head+"%'").list();
            System.out.println(comandSeparator);
            resultList.stream().forEach(System.out::println);
            System.out.println(comandSeparator);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
}
