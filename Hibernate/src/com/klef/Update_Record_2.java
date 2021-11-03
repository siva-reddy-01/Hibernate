package com.klef;
import org.hibernate.*;
import java.util.Scanner;
import org.hibernate.cfg.*;
@SuppressWarnings("unused")
public class Update_Record_2 
{
	@SuppressWarnings({ "unused", "removal", "resource" })
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		
		System.out.println("Enter employee name");
		String name=sc.next();
		
		
		
		Object obj=session.load(Employee.class ,new Integer(id));
	    Employee emp=(Employee)obj;
	    
	    emp.setname(name);
	    Transaction txt=session.beginTransaction();
	    session.update(emp);
	    txt.commit();
	    System.out.println("Entites are updated..");
	    session.close();
	    sf.close();
	}

}
