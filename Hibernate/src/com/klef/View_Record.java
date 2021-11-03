package com.klef;
import org.hibernate.cfg.*;
import org.hibernate.*;
public class View_Record 
{
	@SuppressWarnings("removal")
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Object obj=session.get(Employee.class,new Integer(1290));
		Employee emp=(Employee)obj;
		
		System.out.println(emp.getid()+","+emp.getname()+","+emp.getgender()+","+emp.getsalary());
		Transaction txt=session.beginTransaction();
		txt.commit();
		
		session.close();
		sf.close();
	}

}
