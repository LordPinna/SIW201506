package it.siw.controller.action;

import java.util.LinkedList;
import java.util.List;

import it.siw.model.Customer;
import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;

import javax.servlet.http.HttpServletRequest;

public class CreateOrder implements Action {

	public String perform(HttpServletRequest request) {

		Customer customer = (Customer) request.getSession().getAttribute("customer");

		OrderFacade oFacade = new OrderFacade();
		Order order = oFacade.createOrder(customer);
		List<OrderLine> orderLines = new LinkedList<OrderLine>();
		Float totalPrice = 0.0f;

		request.getSession().setAttribute("currentOrder", order);
		request.getSession().setAttribute("currentOrderLines", orderLines);
		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("yourOrder", "Il tuo ordine");

		return "/customerProducts.jsp";
	}

}