package it.siw.controller.action;

import java.util.List;

import it.siw.model.Administrator;
import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.Customer;

import javax.servlet.http.HttpServletRequest;

public class ListOrder implements Action {

	public String perform(HttpServletRequest request) {
		Administrator admin = (Administrator) request.getSession().getAttribute("administrator");
		if(admin!=null){
			OrderFacade oFacade = new OrderFacade();
			List<Order> orders = oFacade.getOrders();
			request.setAttribute("orders", orders);
			return "/adminOrders.jsp";
		}
		else{
			Long customerId = ((Customer) request.getSession().getAttribute("customer")).getId();
			OrderFacade oFacade = new OrderFacade();
			List<Order> orders = oFacade.getOrdersByCustomerId(customerId);
			request.setAttribute("orders", orders);
			return "/customerOrders.jsp";
		}
	}
}