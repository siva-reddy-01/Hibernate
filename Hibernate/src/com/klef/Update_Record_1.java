package com.klef;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Scanner;
public class Update_Record_1 
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		

		System.out.println("Enter employee name");
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
		session.update(emp);
		txt.commit();
		System.out.println("Records are updated..");
		session.close();
		sf.close();
	}
}
