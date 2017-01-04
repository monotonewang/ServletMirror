package com.demo.servletpath.enhance2.servlet3.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 7 on 2017/1/4.
 */
@WebServlet(name = "Servlet3Register", urlPatterns = "/Servlet3Register", asyncSupported = true)
public class Servlet3Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		// 1.注册操作
		System.out.println("开始注册");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		System.out.println("注册结束");

		// 开启线程。进行发邮件操作.

		AsyncContext context = request.startAsync();// 获取一个异步 上下文对象.

		context.addListener(new AsyncListener() {

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {

			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {

			}

			@Override
			public void onError(AsyncEvent event) throws IOException {

			}

			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				// 监听到线程结束。
				out.flush();
				out.close();
			}
		});

		new Thread(new SendEmail(context)).start();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

class SendEmail implements Runnable {

	private AsyncContext context;

	public SendEmail(AsyncContext context) {
		this.context = context;
	}

	@Override
	public void run() {

		PrintWriter out;
		try {
			out = context.getResponse().getWriter();

			// 2.发送邮件---重新开启一个线程来完成。
			System.out.println("开始发送邮件");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("邮件发送成功");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}