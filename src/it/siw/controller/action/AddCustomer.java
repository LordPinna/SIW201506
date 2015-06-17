package it.siw.controller.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import it.siw.model.Address;
import it.siw.model.Customer;
import it.siw.model.CustomerFacade;

import javax.servlet.http.HttpServletRequest;

public class AddCustomer implements Action {

	public String perform(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dateOfBirths = request.getParameter("dateOfBirth");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");

		Customer customer = new Customer(firstName, lastName, email, password);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dateofBirth = null;
		try {
			dateofBirth = format.parse(dateOfBirths);
		} catch (ParseException e) {
			request.setAttribute("dataError", "Inserisci una data valida");
			return "/newCustomer.jsp";
		}
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateofBirth);
		customer.setDateOfBirth(calendar);

		Address address = new Address(street, city, zipcode, country);

		CustomerFacade cFacade = new CustomerFacade();
		cFacade.addCustomer(customer, address);

		request.setAttribute("success", "La registrazione è stata completata con successo.\nAccedi utilizzando le credenziali da te inserite");


		return "/index.jsp";
	}

}
