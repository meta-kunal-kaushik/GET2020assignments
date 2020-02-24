package userInteraction;

import java.util.Scanner;

import controller.ProductController;
/**
 * This is an implementation class for this assignment
 * @author Kunal
 */
public class Main {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String argv[]) {
		ProductController pc = new ProductController();
		try {
			while (true) {
				System.out.println("1. Add new item");
				System.out.println("2. Remove item");
				System.out.println("3. Update item quantity");
				System.out.println("4. Display user cart");
				System.out.println("5. Exit");
				System.out.println("Enter the option chosen : ");
				int option = scan.nextInt();
				switch (option) {
				// Add new product in the cart
				case 1: {
					pc.showAllProducts();
					System.out.println("Enter the code of product to be added : ");
					int code = scan.nextInt();
					if (pc.isProductInCatalog(code)) {
						System.out.println("Quantity : ");
						int quantity = scan.nextInt();
						pc.addNewProduct(code, quantity);
					} else {
						System.out.println("product is not present in catalog...");
					}
					break;
				}
				// Remove a product from the cart
				case 2: {
					if (!pc.isCartEmpty()) {
						pc.showCartProducts();
						System.out.println("Enter the code of product to be removed : ");
						int code = scan.nextInt();
						if (pc.isProductFound(code)) {
							pc.removeProduct(code);
							System.out.println("Product removed successfully...");
						} else
							System.out.println("product not found...");
					} else {
						System.out.println("Cart is empty...");
					}
					break;
				}
				// Update product quantity
				case 3: {
					if (!pc.isCartEmpty()) {
						pc.showCartProducts();
						System.out.println("Enter the item code to be updated : ");
						int code = scan.nextInt();
						if (pc.isProductFound(code)) {
							System.out.println("quantity : ");
							int quantity = scan.nextInt();
							pc.updateProduct(code, quantity);
							System.out.println("Product updated successfully....");
						} else {
							System.out.println("product not found...");
						}
					} else
						System.out.println("Cart is empty...");
					break;
				}
				// Display user cart
				case 4: {
					System.out.println("Your Cart items are : \n");
					if (!pc.isCartEmpty())
						pc.showCartProducts();
					else
						System.out.println("Cart is empty...");
					break;
				}
				// Exit the program
				case 5: {
					System.out.println("Exit successful");
					System.exit(0);
					break;
				}
				default: {
					System.out.println("Wrong input...");
					break;
				}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception ");
		}
	}
}
