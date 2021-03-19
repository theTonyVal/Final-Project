package src;

import java.util.ArrayList;

public class Cart {
    
	public ArrayList<item>cart;

	public Cart(ArrayList<item>al)
	{
		cart = al;
	}
	
	public void addCart(item i)
	{
		cart.add(i);
	}
	
	public void removeCart(item i)
	{
		cart.remove(i);
	}
}