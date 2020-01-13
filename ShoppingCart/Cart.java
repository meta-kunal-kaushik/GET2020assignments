/*
 * Assignment - 1 (Shopping Cart)
 * */

import java.util.HashMap;
import java.util.Scanner;
public class Cart {

	public static void main(String argv[])
	{
		Item item[]=new Item[3];
		item[0]=new Item("orange",12.5,0);
		item[1]=new Item("apple",10,0);
		item[2]=new Item("kiwi",25,0);
		
		HashMap<Integer,Item> myCartItems = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		Cart.catalog();

		int option;
		
		while(true)
		{
			
			System.out.println("Choose an option :");
			System.out.println("1. Add Item");
			System.out.println("2. Remove Item");
			System.out.println("3. Update Item");
			System.out.println("4. Billing");
			System.out.println("5. Display Cart");
			System.out.println("6. Exit");
			System.out.println("Enter your choice :");
			
			
			try
			{
			option= Integer.parseInt(sc.nextLine());
			
			
			switch(option)
			{
			case 1:// Add an item to the cart
					{
						int item_chosen;
						Cart.catalog();
						System.out.println("Choose the item no : ");
						item_chosen = Integer.parseInt(sc.nextLine());
						if (item_chosen>0 && item_chosen<=item.length)
						{
						System.out.println("Enter the quantity : ");
						int quantity = Integer.parseInt(sc.nextLine());
						item[item_chosen-1].quantity=quantity;
						myCartItems.put(item_chosen-1,item[item_chosen-1]);
						System.out.println("Item added successfully\n");
						}
						else
						{
							System.out.println("This Item Id is not present\n");
							
						}
						break;
					}
			case 2:	// Remove an item from the cart
					{
						
						if(myCartItems.isEmpty())
						{
							System.out.println("The Cart is Already Empty..\n");
						
						}
						else
						{	
						int item_chosen;
						Cart.displayCart(myCartItems);
						System.out.println("\nChoose the Item Id you want to delete : ");
						item_chosen= Integer.parseInt(sc.nextLine());
						if(myCartItems.containsKey(item_chosen-1))
						{	
						myCartItems.remove(item_chosen-1);
						}
						else
						{
							System.out.println("There is no item with such Item Id\n");
						}
						}
						break;
					}
			case 3:	// Update the quantity of an item
					{
						Cart.displayCart(myCartItems);
						
						if(!myCartItems.isEmpty())
						{
						
						System.out.println("Enter the Item Id you want to update : ");
						int item_chosen=Integer.parseInt(sc.nextLine());
						if(myCartItems.containsKey(item_chosen-1))
						{	
						System.out.println("Enter the new quantity : ");
						int quantity=Integer.parseInt(sc.nextLine());
						item[item_chosen-1].quantity=quantity;
						myCartItems.replace(item_chosen-1,item[item_chosen-1]);
						System.out.println("Item updated successfully\n");
						}
						else
						{
							System.out.println("This item is not present in your Cart..\n");
						}	
						}
						break;
					}
			case 4: // Generate a Bill for cart
					{
						if(myCartItems.isEmpty())
						{
							System.out.println("No item to Bill..\n");
							break;
						}
						System.out.println("Are you sure to go for Billing (y/n)");
						if(sc.nextLine().equalsIgnoreCase("n"))
						break;
						
						double total_bill=0;
						Cart.displayCart(myCartItems);
						
						for (Item i : myCartItems.values()) // myCartItems.values() returns an Item class object containing {name,cost,quantity}
						{
						    total_bill += (i.cost*i.quantity);
						}
						
						System.out.println("\nNet Bill Price : "+total_bill+"\n");
						break;
					}
			
			case 5: // Display the cart items
					{
						Cart.displayCart(myCartItems);
						break;
					}
	
	
			case 6: // Quit shopping
					{
						System.out.println("Exit Successfull");
						System.exit(0);
						break;
					}
			default: // if any wrong input chosen
					{
						System.out.println("WRONG CHOICE..\nplease try again\n");
						break;
					}	
			
			}
			}
			catch(NumberFormatException ex)
			{
				System.out.println("WRONG INPUT\n Please choose again\n");
				
						
			}
			
		sc.close();		
		}
		
	}
	
	public static void catalog() //Catalog of all the products
	{
		System.out.println("Choose Items from the list mentioned below :\n");
		System.out.println("............................................................. ");
		System.out.println("........Item Id.......||.....Product.....||.......Cost.......");
		System.out.println(":          1          ||      orange     ||        12.5     :");
		System.out.println(":          2          ||      apple      ||        10       :");
		System.out.println(":          3          ||      kiwi       ||        25       :");
		System.out.println(".............................................................\n");
				
	}
	
	//function  to display cart
	public static void displayCart(HashMap<Integer,Item> myCartItems)
	{
		if(myCartItems.size()==0)
		{
			System.out.println("The cart is empty\n");
		}
		else
		{	
		System.out.println("Items in your cart are :\n");
		System.out.println("....Item ID......||.......Product Name......||......Quantity.....||......Cost......");
		myCartItems.forEach((k,v)->System.out.println("      "+(k+1)+"                      "+ v.name +"                      "+v.quantity+"                "+(v.cost*v.quantity)));
		}

	}
	
}
