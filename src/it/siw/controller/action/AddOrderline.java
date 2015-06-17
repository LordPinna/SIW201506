package it.siw.controller.action;

import java.util.List;
import it.siw.model.Order;
import it.siw.model.OrderFacade;
import it.siw.model.OrderLine;
import javax.servlet.http.HttpServletRequest;

public class AddOrderline implements Action {

	public String perform(HttpServletRequest request) {
		List<OrderLine> orderLines = (List<OrderLine>) request.getSession().getAttribute("currentOrderLines");
		Order order = (Order) request.getSession().getAttribute("currentOrder");
		Float totalPrice = (Float) request.getSession().getAttribute("totalPrice");

		String item = request.getParameter("item");
		Float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
		int quantity;

		try {
			quantity = Integer.parseInt(request.getParameter("quantity"));
			if(quantity <= 0){
				request.setAttribute("quantityError", "Inserire una quantità valida");
				return "/customerProducts.jsp";
			}
		} catch (Exception NoNumber){
			request.setAttribute("quantityError", "Inserire una quantità valida");
			return "/customerProducts.jsp";
		}

		for (OrderLine o : orderLines){
			if(o.getItem().equals(item)){
				int oldQuantity = o.getQuantity();
				o.setQuantity(quantity);
				totalPrice = totalPrice + o.getUnitPrice() * (o.getQuantity() - oldQuantity); 
				OrderFacade oFacade = new OrderFacade();
				oFacade.updateOrderLine(o.getId(), quantity);

				request.getSession().setAttribute("totalPrice", totalPrice);
				request.getSession().setAttribute("currentOrderLines", orderLines);

				return "/customerProducts.jsp";
			}
		}

		totalPrice = totalPrice + quantity * unitPrice;


		OrderFacade oFacade = new OrderFacade();
		OrderLine orderLine = oFacade.createOrderLine(item, quantity, unitPrice, order.getId());
		orderLines.add(orderLine);

		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("currentOrderLines", orderLines);

		return "/customerProducts.jsp";
	}
}