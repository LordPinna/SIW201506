package it.siw.controller.action;

import javax.servlet.http.HttpServletRequest;

public class DoLogout implements Action {

	public String perform(HttpServletRequest request) {
		
		request.getSession().removeAttribute("customer");
		request.getSession().removeAttribute("administrator");
		request.getSession().removeAttribute("products");
		request.getSession().removeAttribute("currentOrder");
		request.getSession().removeAttribute("currentOrderLines");
		request.getSession().removeAttribute("totalPrice");
		request.getSession().removeAttribute("yourOrder");

		return "/index.jsp";
	}

}
