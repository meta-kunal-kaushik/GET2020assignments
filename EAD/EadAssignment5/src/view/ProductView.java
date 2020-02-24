package view;

import java.util.HashMap;
import Dao.ProductDao;
import model.Product;
/**
 * this is View class for product class
 * @author Kunal
 */
public class ProductView {
	/**
	 * This function will show the user cart products
	 * @param productList
	 */
	public void showUserCartProducts(HashMap<Integer, Product> productList) {
		productList.forEach((key, value) -> System.out.println(value));
	}
	/**
	 * This function will show the Product Catalog to the user
	 */
	public void showAllProducts() {
		System.out.println("CODE        NAME                TYPE             PRICE");
		new ProductDao().getProductCatalog().forEach((key, value) -> System.out.println("  " + value.getCode()
				+ "         " + value.getName() + "              " + value.getType() + "      " + value.getPrice()));
	}
}
