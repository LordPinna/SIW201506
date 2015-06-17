package it.siw.controller.helper;

import it.siw.model.Administrator;
import it.siw.model.AdministratorFacade;
import it.siw.model.Customer;
import it.siw.model.CustomerFacade;

import javax.servlet.http.HttpServletRequest;

public class HelperLogin {

	public boolean isValid(HttpServletRequest request){

		boolean errors = false;
		String email = request.getParameter("username");
		String username = email;
		String password = request.getParameter("password");
		CustomerFacade cFacade = new CustomerFacade();
		Customer customer = cFacade.getCustomer(email, password);
		if (customer!=null)
			request.getSession().setAttribute("customer", customer);
		else{
			AdministratorFacade aFacade = new AdministratorFacade();
			Administrator administrator = aFacade.getAdministrator(username, password);
			if (administrator!=null) 
				request.getSession().setAttribute("administrator", administrator);
			else {
				request.setAttribute("loginErr", "Invalid username or password");
				errors = true;
			}
		}
		return !errors;
	}
}

