package it.siw.controller.action;

import it.siw.model.Customer;
import it.siw.model.CustomerFacade;

import javax.servlet.http.HttpServletRequest;

public class GetCustomer implements Action {


	public String perform(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("customerId"));

		CustomerFacade cFacade = new CustomerFacade();
		Customer customer = cFacade.getCustomerById(id);

		request.setAttribute("customer", customer);

		return "/adminCustomer.jsp";

	}

}
