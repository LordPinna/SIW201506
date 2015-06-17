package it.siw.controller.action;

import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RemoveOrderline implements Action {

	public String perform(HttpServletRequest request) {
		List<OrderLine> orderLines = (List<OrderLine>) request.getSession().getAttribute("currentOrderLines");
		Order order = (Order) request.getSession().getAttribute("currentOrder");
		Float totalPrice = (Float) request.getSession().getAttribute("totalPrice");
		String item = request.getParameter("item");

		Iterator<OrderLine> iter = orderLines.iterator();
		while(iter.hasNext()){
			OrderLine o = iter.next();
			if(o.getItem().equals(item)){
				OrderFacade oFacade = new OrderFacade();
				oFacade.removeOrderLine(o.getId());
				iter.remove();
				totalPrice = totalPrice - o.getQuantity() * o.getUnitPrice();
			}
		}

		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("currentOrderLines", orderLines);

		return "/customerProducts.jsp";
	}
}