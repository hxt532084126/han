package cn.han.job.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import cn.han.job.domain.Customer;

/**
 * 
 * @ClassName: Test1
 * @Description: Test all the function of Hiberante, which could help me to know
 *               all the staff about it.
 * @author Heaven
 * @date 2017-2-17 上午10:52:55
 * @version v1.0
 */

public class Test1 {
	/**
	 * 
	 * @Title: main
	 * @Description: you know what I want to do, just for review and memorize.
	 * @return void
	 * @throws
	 * @param
	 */
	public static void main(String[] args) {
		// Hibernate框架加载核心配置文件
		Configuration configure = new Configuration().configure();
		// 创建一个SessionFactory . 获得Session--相当于 Connection
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 获得Session对象
		Session session = sessionFactory.openSession();
		// m默认的情况下,事务是不自动提交的
		Transaction tx = session.beginTransaction();
		// 业务逻辑

		// 向数据库中插入一条记录
		// Customer customer = new Customer();
		// customer.setAge(26);
		// customer.setUserName("hxt");
		// session.save(customer);

		// 获取主键(get找不到会抛NullPointException)
		// Customer customer1 = (Customer)session.get(Customer.class, 1);
		// System.out.println(customer1.toString());
		//
		//
		// //获取主键(load找不到会抛ObjectNotFoundException)
		// Customer customer2 = (Customer)session.load(Customer.class, 6);
		// System.out.println(customer2.toString());

		// 修改语句,如果其他数据没设置,那么就自动设置为0(int数据),null(String类型)
		// 如果找不到的话,就会抛出staleStateException
		// Customer customer = new Customer();
		// customer.setUserName("hhh");
		// customer.setAge(22);
		// session.update(customer);

		// 删除语句
		// 第一种方式: session.delete(customer)

		// Customer customer = new Customer();
		// customer.setId(4);
		// session.delete(customer);

		// 删除语句
		// 第二种方式 : 先查找,再删除
		// Customer customer = (Customer) session.get(Customer.class, 3);
		// session.delete(customer);

		// 查询所有
		// 1. HQL的模式

		// Query query =
		// session.createQuery("from Customer where userName = ?");
		// Query customers = query.setParameter(0, "han");
		// @SuppressWarnings("unchecked")
		// List<Customer> list = (List<Customer>) customers.list();
		// for (Customer customer : list) {
		// System.out.println(customer.getId() + " : "
		// + customer.getUserName() + " : " + customer.getAge());
		// }

		// 2. QBC的模式
		// Criteria criteria = session.createCriteria(Customer.class);
		// criteria.add(Restrictions.eq("userName", "hxt"));
		// @SuppressWarnings("unchecked")
		// List<Customer> list = (List<Customer>)criteria.list();
		// for(Customer customer : list){
		// System.out.println(customer.getId() + " : "
		// + customer.getUserName() + " : " + customer.getAge());
		// }

		// 3. SQL的模式
		 SQLQuery query = session.createSQLQuery("select * from customer");
		 query.addEntity(Customer.class);
		 @SuppressWarnings("unchecked")
		 List<Customer> list = (List<Customer>) query.list();
		 for (Customer customer : list) {
		 System.out.println(customer.getId() + " : "
		 + customer.getUserName() + " : " + customer.getAge());
		 }
		
		

		// 事务提交
		tx.commit();
		// 释放资源
		session.close();
		sessionFactory.close();
	}
}
