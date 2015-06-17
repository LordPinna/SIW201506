package it.siw.controller.action;

import java.util.List;

import it.siw.model.Product;
import it.siw.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class ListProduct implements Action {

	public String perform(HttpServletRequest request) {
		ProductFacade pFacade = new ProductFacade();
		List<Product> products = pFacade.listProducts();
		request.getSession().setAttribute("products", products);
		if(request.getSession().getAttribute("administrator")!=null)
			return "/adminProducts.jsp";
		else if(request.getSession().getAttribute("customer")!=null)
			return "/customerProducts.jsp";
		return "/guestProducts.jsp";
	}
}
