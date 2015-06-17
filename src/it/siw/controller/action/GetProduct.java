package it.siw.controller.action;

import it.siw.model.Product;
import it.siw.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class GetProduct implements Action {

	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		ProductFacade pFacade = new ProductFacade();
		Product product = pFacade.getProductById(id);
		request.setAttribute("product", product);
		if(request.getSession().getAttribute("administrator")!=null)
			return "/adminProduct.jsp";
		else if(request.getSession().getAttribute("customer")!=null)
			return "/customerProduct.jsp";
		return "/guestProduct.jsp";
	}
}