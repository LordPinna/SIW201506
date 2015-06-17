package it.siw.controller;

import it.siw.controller.action.Action;

import java.io.IOException;
import java.util.Scanner;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/*") 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//@EJB(beanName="cFacade")
	//private CustomerFacade customerFacade;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nextPage = null;
		String actionName = path2action(request);
		Action action;
		try {
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request);
		} catch (Exception e) {
			nextPage = "/index.jsp";
		} 
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		return;
	}

	private String path2action(HttpServletRequest request) {

		String path = request.getPathInfo(); 
		String modelCommand = path.substring(1);
		Scanner scanner = new Scanner(modelCommand).useDelimiter("\\.");
		String model = scanner.next();
		model = model.substring(0,1).toUpperCase() + model.substring(1);
		String action = scanner.next();
		action = action.substring(0,1).toUpperCase() + action.substring(1);
		String actionName = "it.siw.controller.action." + action + model;
		return actionName;
	}
}
