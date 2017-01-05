package com.demo.servletpath.enhance2.permission;

import com.demo.servletpath.dbutils.customer.utils.DataSourceUtils;
import com.demo.servletpath.enhance2.permission.annoation.BookInfo;
import com.demo.servletpath.enhance2.permission.domain.User;
import com.demo.servletpath.enhance2.permission.service.BookService;
import com.demo.servletpath.enhance2.permission.service.BookServiceImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by 7 on 2017/1/5.
 */
//对service进行处理，
public class BookServiceFactory {
	private static BookService service = new BookServiceImpl();

	public static BookService getInstance() {

		BookService proxy = (BookService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				boolean annotationPresent = method.isAnnotationPresent(BookInfo.class);
				if(annotationPresent){
					return method.invoke(service,args);
				}
				// 1.得到Method方法要想访问需要的权限名称.
				BookInfo info = method.getAnnotation(BookInfo.class);

				User users = (User) args[0];
				if (users == null) {//没有登录
					new RuntimeException();
				}

				String sql = "SELECT privileges.name FROM pusers,PRIVILEGES,userprivilege WHERE pusers.id=userprivilege.user_id AND privileges.id=userprivilege.privilege_id AND pusers.id=?";
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				List<Object> pnames = runner.query(sql, new ColumnListHandler<>(), users.getId());
				System.out.println("当前用户是" + users.getUsername() + ",它具有的权限是:"
						+ pnames);

				//获取值
				String value = info.value();
//				System.out.println(value);
				if (pnames.contains(value)) {
					Object obj = method.invoke(service, args);
					// 真实行为访问 后
					return obj;
				} else {
					throw new RuntimeException("权限不足");
				}
			}
		});
		return proxy;
	}
}
