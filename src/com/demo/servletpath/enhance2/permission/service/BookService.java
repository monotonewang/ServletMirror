package com.demo.servletpath.enhance2.permission.service;

import com.demo.servletpath.enhance2.permission.annoation.BookInfo;
import com.demo.servletpath.enhance2.permission.domain.User;

/**
 * Created by 7 on 2017/1/5.
 */
public interface BookService {
	@BookInfo("添加图书")
	void addBook(User user) throws Exception;

	@BookInfo("修改图书")
	void deleteBook(User user) throws Exception;

	@BookInfo("删除图书")
	void updateBook(User user) throws Exception;

	@BookInfo("查找图书")
	void searchBook(User user) throws Exception;
}
