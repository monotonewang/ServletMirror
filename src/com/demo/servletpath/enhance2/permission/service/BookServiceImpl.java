package com.demo.servletpath.enhance2.permission.service;

import com.demo.servletpath.enhance2.permission.domain.User;

/**
 * Created by 7 on 2017/1/5.
 */
public class BookServiceImpl implements BookService {
	@Override
	public void addBook(User user) {
		System.out.println("add");
	}

	@Override
	public void deleteBook(User user) {
		System.out.println("delete");
	}

	@Override
	public void updateBook(User user) {
		System.out.println("update");
	}

	@Override
	public void searchBook(User user) {
		System.out.println("search");
	}
}
