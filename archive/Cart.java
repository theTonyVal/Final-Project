package archive;

import java.util.ArrayList;
import src.item.*;

public class Cart {
    
	public ArrayList<Item>cart;

	public Cart(ArrayList<Item>al)
	{
		cart = al;
	}
	
	public void addCart(Item i)
	{
		cart.add(i);
	}
	
	public void removeCart(Item i)
	{
		cart.remove(i);
	}
}