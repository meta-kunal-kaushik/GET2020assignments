package facade;

import Dao.ProductDao;
import view.ProductView;
/**
 * This is facade class for product class
 * @author Kunal
 *
 */
public class ProductFacade {
	ProductView view;
	ProductDao dao;
	
	public ProductFacade() {
		dao = new ProductDao();
		view = new ProductView();
	}
	/**
	 * This function will make a call to Product Dao class to add new product
	 * @param code
	 * @param quantity
	 */
	public void addProduct(int code, int quantity) {
		dao.addProductByCode(code, quantity);
	}
	/**
	 * This function will make a call to Product Dao class to update product
	 * @param code
	 * @param quantity
	 */
	public void updateProductList(int code, int quantity) {
		dao.updateProductList(code, quantity);
	}
	/**
	 * This function will make a call to Product Dao class to show user cart
	 */
	public void showUserCartProducts() {
		dao.showUserCartProducts();
	}
	/**
	 * This function will make a call to Product Dao class to remove a product
	 * @param code
	 */
	public void removeProduct(int code) {
		dao.removeProduct(code);
	}
	/**
	 * This function will check whether user cart is empty or not
	 * @return boolean value
	 */
	public boolean isCartEmpty() {
		if (dao.getUserProductList().isEmpty())
			return true;
		return false;
	}
	/**
	 * This function will check whether product is present in user cart or not
	 * @param code
	 * @return boolean value
	 */
	public boolean isProductFound(int code) {
		if (dao.getUserProductList().containsKey(code)) {
			return true;
		}
		return false;
	}
	/**
	 * This function will check whether the product to be added by the user is present in catalog or not
	 * @param code
	 * @return boolean value
	 */
	public boolean isProductInCatalog(int code) {
		if (dao.getProductCatalog().containsKey(code))
			return true;
		else
			return false;
	}
}
