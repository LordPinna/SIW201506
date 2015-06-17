package it.siw.controller.action;

import it.siw.controller.helper.HelperLogin;

import javax.servlet.http.HttpServletRequest;

public class DoLogin implements Action {


	public String perform(HttpServletRequest request) {
		HelperLogin helper = new HelperLogin();
		if(helper.isValid(request)){
			if(request.getSession().getAttribute("customer")!=null)
				return "/customerHome.jsp";
			else if(request.getSession().getAttribute("administrator")!=null)
				return "/adminHome.jsp";
		}
		return "/index.jsp";
	}

}
