package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Transaction tx=null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getHibernateUtil();
            Session session = sessionFactory.openSession();
            tx=session.beginTransaction();
//            Customer customer=new Customer("konda","kondalu@gmail.com",565656);
//            session.save(customer);
            Customer customer=session.load(Customer.class,1);
            customer.setEmail("Konda@gmail.com");
            customer.setName("yedukondal");

            tx.commit();
            session.close();

        }catch (Exception ex)
        {
            tx.rollback();
            ex.printStackTrace();
        }

    }
}