package it.siw.controller.action;

import java.util.List;

import it.siw.model.Product;
import it.siw.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class AddProduct implements Action {

	public String perform(HttpServletRequest request) {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		Float price = Float.parseFloat(request.getParameter("price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
		String description = request.getParameter("description");
		Product product = new Product(name, price, stockQuantity, code);
		product.setDescription(description);
		ProductFacade pFacade = new ProductFacade();
		pFacade.addProduct(product);
		pFacade = new ProductFacade();
		List<Product> products = pFacade.listProducts();
		request.getSession().setAttribute("products", products);
		return "/adminProducts.jsp";
	}

}
