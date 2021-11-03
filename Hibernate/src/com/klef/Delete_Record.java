package com.klef;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Delete_Record 
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		@SuppressWarnings("removal")
		Object obj=session.load(Employee.class, new Integer(1290));
		Employee emp=(Employee)obj;
		
		Transaction txt=session.beginTransaction();
		session.delete(emp);
		txt.commit();
		System.out.println("Records are deleted..");
		session.close();
		sf.close();
	}

}
