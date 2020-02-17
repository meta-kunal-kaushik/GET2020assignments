package com.restfull.webServiceAssignment;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dao.Dao;

@Path("inventory")
public class Inventory {

	Dao items = new Dao();
	/**
	 * @return all the items present in the database
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Item> getAllItems() {
		System.out.println("helloo...");
		return items.getAllItems();
	}
	
	/**
	 * 
	 * @param name
	 * @return this function returns a particular item from the database
	 */
	@GET
	@Path("{name}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Item getParticularAlien(@PathParam("name") String name) {
		return items.getItemByName(name);
	}
	
	/**
	 * This item will add the new item in the database
	 * @param item
	 */
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Item addNewAlien(Item item) {
		items.addNewItem(item);
		System.out.println("new item : "+item);
		return item; 
		}
	/**
	 * This function will update the specified
	 * @param item
	 * @param name
	 */
	@PUT
	@Path("{name}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void updateItem(Item item , @PathParam("name") String name) {
	items.updateItem(item, name);
	}
	
	/**
	 * This function will update the whole array of items with a new item array
	 * @param itemList
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void updateAllItem(ArrayList <Item> itemList) {
	items.updateAllItem(itemList);
	}
		
	/**
	 * This function will delete the specified item from the database
	 * @param name
	 */
	@DELETE
	@Path("{name}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void deleteItem(@PathParam("name") String name) {
		items.deleteItem(name);
	}
	
	/**
	 * This function will delete all the items from the database
	 */
	@DELETE
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void deleteAllItems() {
	items.deleteAllItem();	
	}
}
