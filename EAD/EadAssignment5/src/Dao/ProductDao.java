package Dao;

import java.util.HashMap;
import model.Product;
import view.ProductView;
/**
 * This is a data Access Object for product class
 * @author Kunal
 *
 */
public class ProductDao {
	HashMap<Integer, Product> productCatalog = new HashMap<Integer, Product>();
	HashMap<Integer, Product> userProductList = new HashMap<Integer, Product>();
	ProductView view;

	public HashMap<Integer, Product> getUserProductList() {
		return userProductList;
	}

	public HashMap<Integer, Product> getProductCatalog() {
		return productCatalog;
	}
	/**
	 * constructor tom initialize the product Catalog
	 */
	public ProductDao() {
		view = new ProductView();
		productCatalog.put(1, new Product(1, "soap         ", "lux    ", 0, 20));
		productCatalog.put(2, new Product(2, "milk         ", "amul   ", 0, 30));
		productCatalog.put(3, new Product(3, "cheese       ", "feta   ", 0, 80));
		productCatalog.put(4, new Product(4, "soap         ", "dove   ", 0, 25));
		productCatalog.put(5, new Product(5, "milk         ", "saras  ", 0, 40));
		productCatalog.put(6, new Product(6, "milk product ", "paneer ", 0, 120));
		productCatalog.put(7, new Product(7, "peanut butter", "sundrop", 0, 275));
	}
	/**
	 * This class will add a product to user cart
	 * @param code
	 * @param quantity
	 */
	public void addProductByCode(int code, int quantity) {
		Product product = new Product();
		double price = productCatalog.get(code).getPrice() * quantity;
		product.setQuantity(quantity);
		product.setPrice(price);
		product.setName(productCatalog.get(code).getName());
		product.setCode(productCatalog.get(code).getCode());
		product.setType(productCatalog.get(code).getType());
		userProductList.put(code, product);
	}
	/**
	 * This function will send a request to ProductView class to show the user cart
	 */
	public void showUserCartProducts() {
		new ProductView().showUserCartProducts(userProductList);
	}
	/**
	 * This function will update a product by its quantity
	 * @param code
	 * @param quantity
	 */
	public void updateProductList(int code, int quantity) {
		double price = productCatalog.get(code).getPrice() * quantity;
		userProductList.get(code).setQuantity(quantity);
		userProductList.get(code).setPrice(price);
	}
	/**
	 * This function will remove a product from the user cart
	 * @param code
	 */
	public void removeProduct(int code) {
		userProductList.remove(code);
	}

}
