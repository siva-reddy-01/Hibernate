package com.klef;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

public class HCQLDemo10
{

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		//projections
		//row count
		Criteria c=session.createCriteria(Employee.class);
		c.setProjection(Projections.rowCount());
		List list=c.list();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
		//count
		Criteria c1=session.createCriteria(Employee.class);
		c1.setProjection(Projections.count("salary"));
		List list1=c1.list();
		for(int i=0;i<list1.size();i++)
		{
			System.out.println(list1.get(i));
		}
		
		
		//sum
		Criteria c2=session.createCriteria(Employee.class);
		c2.setProjection(Projections.sum("salary"));
		List list2=c2.list();
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(list2.get(i));
		}
		
		
		//min
		Criteria c3=session.createCriteria(Employee.class);
		c3.setProjection(Projections.min("salary"));
		List list3=c3.list();
		for(int i=0;i<list3.size();i++)
		{
			System.out.println(list3.get(i));
		}
		
		//max
		Criteria c4=session.createCriteria(Employee.class);
		c4.setProjection(Projections.max("salary"));
		List list4=c4.list();
		for(int i=0;i<list4.size();i++)
		{
			System.out.println(list4.get(i));
		}
		
		Criteria c5=session.createCriteria(Employee.class);
		c5.setProjection(Projections.avg("salary"));
		List list5=c5.list();
		for(int i=0;i<list5.size();i++)
		{
			System.out.println(list5.get(i));
		}
		
		//projects with order desc
		Criteria c6=session.createCriteria(Employee.class);
		c6.setProjection(Projections.id());
		c6.addOrder(Order.desc("id"));
		List list6=c6.list();
		for(int i=0;i<list6.size();i++)
		{
			System.out.println(list6.get(i));
		}
		
		//projection with Restriction with order
		Criteria c7=session.createCriteria(Employee.class);
		c7.setProjection(Projections.property("id"));
		c7.add(Restrictions.gt("salary", 20000));
		c7.addOrder(Order.desc("id"));
		List list7=c7.list();
		for(int i=0;i<list7.size();i++)
		{
			System.out.println(list7.get(i));
		}
	}
}
