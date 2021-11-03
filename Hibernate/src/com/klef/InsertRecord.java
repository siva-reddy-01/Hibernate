package com.klef;
import java.sql.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;


@SuppressWarnings("unused")
public class InsertRecord 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		
		System.out.println("Enter employe name");
		String name=sc.next();
		
		System.out.println("Enter employee gender");
		String gender=sc.next();
		
		System.out.println("Enter employee salary");
		int salary=sc.nextInt();
		
		Employee emp=new Employee();
		emp.setid(id);
		emp.setname(name);
		emp.setgender(gender);
		emp.setsalary(salary);
		
		Transaction txt=session.beginTransaction();
		session.save(emp);
		txt.commit();
		System.out.println("Records are inserted");
		session.close();
		sf.close();

	}

}
