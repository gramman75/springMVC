package com.gramman75;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class HelloServlet extends HttpServlet {
	
	 @Override
	 public void init() throws ServletException {
		 System.out.println("init");
		 super.init();
	 }

	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("doGet");

		 ApplicationContext context =  (ApplicationContext)getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		 HelloService helloService = context.getBean(HelloService.class);

		 resp.getWriter().println("<html>");
		 resp.getWriter().println("<head></head>");
		 resp.getWriter().println("<body>");
		 resp.getWriter().println("<h1>Hello " + helloService.getName() + "</h1>");
//		 resp.getWriter().println("<h1>Hello Servlet</h1>");
		 resp.getWriter().println("</body>");
		 resp.getWriter().println("</html>");
	 }	

}
