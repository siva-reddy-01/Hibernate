package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

@SuppressWarnings("unused")
public class HCQLDemo4 
{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		//le(less than or equal to
		Criteria c=session.createCriteria(Employee.class);
		c.add((Restrictions.le("salary",20000)));
		List<Employee> list=c.list();
		for(Employee emp:list)
		{
			System.out.println(emp.getid()+","+emp.getname()+","+emp.getgender()+","+emp.getsalary());
		}

	}
}
