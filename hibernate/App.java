package com.hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class App 
{
    public static void main( String[] args )
    {
      
    	Student s1 = new Student();
    	
    	s1.setId(101);
    	s1.setName("shreyank");
    	s1.setStudentclass("PG-DAC");
    	
    	
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	
    	SessionFactory sf = meta.getSessionFactoryBuilder().build();
    	
    	Session session = sf.openSession();
    	
    	
    	Transaction t = session.beginTransaction();
    	
    	session.persist(s1);
    	
    	t.commit();
    	
    	System.out.println("succesfully Updated");
    	sf.close();
    	
    	session.close();
    	
    	
    }
}
