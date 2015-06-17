package it.siw.controller.action;

import java.util.List;

import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;

import javax.servlet.http.HttpServletRequest;

public class CloseOrder implements Action {

	public String perform(HttpServletRequest request) {

		Order order = (Order)request.getSession().getAttribute("currentOrder");
		List<OrderLine> orderLines = (List<OrderLine>) request.getSession().getAttribute("currentOrderLines");
		Float totalPrice = (Float) request.getSession().getAttribute("totalPrice");


		OrderFacade oFacade = new OrderFacade();
		oFacade.closeOrder(order.getId());

		request.getSession().removeAttribute("currentOrder");
		request.getSession().removeAttribute("currentOrderLines");
		request.getSession().removeAttribute("totalPrice");
		request.getSession().removeAttribute("yourOrder");
		
		request.setAttribute("currentOrder", order);
		request.setAttribute("currentOrderLines", orderLines);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("orderCompleted", "L'ordine è stato chiuso con successo");

		return "/newOrder.jsp";
	}

}
