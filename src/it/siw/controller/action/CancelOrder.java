package it.siw.controller.action;

import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CancelOrder implements Action {

	public String perform(HttpServletRequest request) {

		Order currentOrder = (Order) request.getSession().getAttribute("currentOrder");
		try{
			Long orderId = Long.valueOf(request.getParameter("orderId"));

			OrderFacade oFacade = new OrderFacade();
			List<OrderLine> orderLines = oFacade.getOrderLines(orderId);

			for(OrderLine o : orderLines){
				oFacade = new OrderFacade();
				oFacade.removeOrderLine(o.getId());
			}

			oFacade = new OrderFacade();
			oFacade.removeOrder(orderId);

			if(currentOrder!=null && orderId.equals(currentOrder.getId())){
				request.getSession().removeAttribute("currentOrder");
				request.getSession().removeAttribute("currentOrderLines");
				request.getSession().removeAttribute("totalPrice");
				request.getSession().removeAttribute("yourOrder");
			}

			return "/customerHome.jsp";
		} catch(Exception NullOrderId){
			List<OrderLine> orderLines = (List<OrderLine>) request.getSession().getAttribute("currentOrderLines");

			for(OrderLine o : orderLines){
				OrderFacade oFacade = new OrderFacade();
				oFacade.removeOrderLine(o.getId());
			}

			OrderFacade oFacade = new OrderFacade();
			oFacade.removeOrder(currentOrder.getId());

			request.getSession().removeAttribute("currentOrder");
			request.getSession().removeAttribute("currentOrderLines");
			request.getSession().removeAttribute("totalPrice");
			request.getSession().removeAttribute("yourOrder");

			return "/customerProducts.jsp";
		}
	}
}