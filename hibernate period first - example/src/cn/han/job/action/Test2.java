package cn.han.job.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import cn.han.job.domain.Customer;
import cn.han.job.utils.HibernateUtils;

public class Test2 {
	public static void main(String[] args) {
		Session session = HibernateUtils.openSession();
		// 查询操作其实是不需要提交事务的
		// Transaction transaction = session.getTransaction();

		Query query = session.createQuery("from Customer where userName = ?");
		Query query2 = query.setParameter(0,"han");
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) query2.list();
		for (Customer c : list) {
			System.out.println(c.getId() + " : " + c.getUserName() + " : "
					+ c.getAge());
		}

		session.close();

	}
}
