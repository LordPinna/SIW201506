package it.siw.controller.action;

import java.util.List;

import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;

import javax.servlet.http.HttpServletRequest;

public class GetOrder implements Action {

	public String perform(HttpServletRequest request) {

		Long orderId = Long.valueOf(request.getParameter("orderId"));
		Float totalPrice = 0.0f;

		OrderFacade oFacade = new OrderFacade();
		Order order = oFacade.getOrder(orderId);
		oFacade = new OrderFacade();
		List<OrderLine> orderLines = oFacade.getOrderLines(orderId);
		for(OrderLine o : orderLines){
			totalPrice = totalPrice + o.getQuantity() * o.getUnitPrice();
		}
		if(request.getSession().getAttribute("administrator")!=null){

			request.setAttribute("order", order);
			request.setAttribute("orderLines", orderLines);
			request.setAttribute("orderTotalPrice", totalPrice);

			return "/adminOrder.jsp";

		} else if(order.getClosedTime()==null){

			request.getSession().setAttribute("currentOrder", order);
			request.getSession().setAttribute("currentOrderLines", orderLines);
			request.getSession().setAttribute("totalPrice", totalPrice);
			request.getSession().setAttribute("yourOrder", "Il tuo ordine");

			return "/customerProducts.jsp";

		} else {

			request.setAttribute("order", order);
			request.setAttribute("orderLines", orderLines);
			request.setAttribute("orderTotalPrice", totalPrice);

			return "/customerOrder.jsp";
		}
	}

}