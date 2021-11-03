package com.klef;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class skill6 
{
	public static void Insert_Record() 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		@SuppressWarnings("resource")
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
	
	public static void Update_Record()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		System.out.println("Enter employee salary");
		int salary=sc.nextInt();
		
		@SuppressWarnings("removal")
		Object obj=session.load(Employee.class ,new Integer(id));
	    Employee emp=(Employee)obj;
	    
	    
	    emp.setsalary(salary);
	    Transaction txt=session.beginTransaction();
	    session.update(emp);
	    txt.commit();
	    System.out.println("salary is updated..");
	    session.close();
	    sf.close();
	}
	public static void Veiw_Record()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		int id=sc.nextInt();
		@SuppressWarnings("removal")
		Object obj=session.get(Employee.class,new Integer(id));
		Employee emp=(Employee)obj;
		
		System.out.println(emp.getid()+","+emp.getname()+","+emp.getgender()+","+emp.getsalary());
		Transaction txt=session.beginTransaction();
		txt.commit();
		
		session.close();
		sf.close();
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Delete_Record()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria c3=session.createCriteria(Employee.class);
		c3.setProjection(Projections.min("salary"));
		List list3=c3.list();
		for(int i=0;i<list3.size();i++)
		{
			System.out.println(list3.get(i));
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		boolean exit=false;
		
		while(!exit)
		{
			System.out.println("1.select the details of the employee");
			System.out.println("2.update the salary of the employee with Average of all employee salaries");
			System.out.println("3.Delete the salary of the employee whose salary is minimun");
			System.out.println("4.Insert the new employee details");
			System.out.println("5.exit the program");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			       Veiw_Record();
			       break;
			case 2:
			       Update_Record();
			       break;
			       
			case 3:
				  Delete_Record();
				  break;
			case 4:
				  Insert_Record();
				  break;
			default:
				  System.out.println("please try again");
				  break;
			}
		}
		sc.close();	
	}
}
