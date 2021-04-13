package src.item;

//The CPU class which takes in parameters to be the CPU object 
public class Cpu implements Item
{   
    private String model;
    private double price;
    private int threads;
    private int quantity;
    private String id;

    public Cpu(String _model, double _price, int _quantity, String _id)
    {
        model = _model;
        price = _price;
        quantity = _quantity;
        id = _id;
    }

    //Set values in editing
	public void setModel(String m)
    {
        model = m;
    }
	public void setPrice(double newPrice)
    {
        price = newPrice;
    }
	public void setQuantity(int newQuan)
    {
        quantity = newQuan;
    }
    public void setId(String newId)
    {
        id = newId;
    }
    
    //Get methods to get values
    public String getModel() 
    {
    	return model;
    }
    public int getQuantity()
    {
		return quantity;
    }
    public double getPrice()
    {
    	return price;
    }
    public String getId()
    {
    	return id;
    }
    
    //Methods for database
    public String csvString()
    {
    	return model + "," + price + "," + quantity + "," + id;
    }
    public void sell()
    {
    	quantity -= 1;
    }
    public String toString()
    {
        return model + " " + price + " " + quantity + " " + id;
    }
}
