package controller;

import facade.ProductFacade;
import view.ProductView;

/**
 * This is a product controller class
 * 
 * @author Kunal
 *
 */
public class ProductController {
	ProductFacade facade;
	ProductView view;
	/**
	 * constructor to initialize objects
	 */
	public ProductController() {
		view = new ProductView();
		facade = new ProductFacade();
	}
	/**
	 * This function will send a request to facade class to add a product
	 * @param code
	 * @param quantity
	 */
	public void addNewProduct(int code, int quantity) {
		facade.addProduct(code, quantity);
	}
	/**
	 * This function will send a request to facade class to update the quantity of product
	 * @param code
	 * @param quantity
	 */
	public void updateProduct(int code, int quantity) {
		facade.updateProductList(code, quantity);
	}
	/**
	 * This function will send a request to facade class to show user cart products
	 */
	public void showCartProducts() {
		facade.showUserCartProducts();
	}
	/**
	 * This function will send a request to facade class to show product catalog
	 */
	public void showAllProducts() {
		view.showAllProducts();
	}
	/**
	 * This function will send a request to facade class to remove user cart products
	 * @param code
	 */
	public void removeProduct(int code) {
		facade.removeProduct(code);
	}
	/**
	 * This function will send a request to facade class to check whether user cart is empty or not
	 * @return boolean value
	 */
	public boolean isCartEmpty() {
		return facade.isCartEmpty();
	}
	/**
	 * This function will send a request to facade class to check that a product is present in user cart or not
	 * @param code
	 * @return boolean value
	 */
	public boolean isProductFound(int code) {
		return facade.isProductFound(code);
	}
	/**
	 * This function will send a request to facade class to check that a product is present in product Catalog or not
	 * @param code
	 * @return boolean value
	 */
	public boolean isProductInCatalog(int code) {
		return facade.isProductInCatalog(code);
	}

}
