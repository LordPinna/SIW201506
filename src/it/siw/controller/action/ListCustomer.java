package it.siw.controller.action;

import java.util.List;

import it.siw.model.Customer;
import it.siw.model.CustomerFacade;

import javax.servlet.http.HttpServletRequest;

public class ListCustomer implements Action {


	public String perform(HttpServletRequest request) {

		CustomerFacade cFacade = new CustomerFacade();
		List<Customer> customers = cFacade.getCustomers();

		request.setAttribute("customers", customers);

		return "/adminCustomers.jsp";
	}
}