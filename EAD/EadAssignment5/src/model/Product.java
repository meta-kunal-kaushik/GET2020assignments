package model;
/**
 * this is a POJO class
 * @author Kunal
 *
 */
public class Product {
	int code;
	String type;
	String name;
	int quantity;
	double price;

	public Product(int code, String type, String name, int quantity, double price) {
		this.setCode(code);
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setType(type);
	}

	public Product() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", type=" + type + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
}
