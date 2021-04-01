package src.item;

public class cpu implements item
{   
    private String model;
    private double price;
    private int threads;
    private int quantity;
    private String id;

    public cpu(String _model, double _price, int _quantity, String _id)
    {
        model = _model;
        price = _price;
        quantity = _quantity;
        id = _id;
    }

    @Override
	public String model()
    {
        return model;
    }

    @Override
	public double price()
    {
        return price;
    }

    @Override
	public int quantity()
    {
        return quantity;
    }

    @Override
	public void sell()
    {
        quantity -= 1;
    }

    public String id()
    {
        return id;
    }

    @Override
	public String toString()
    {
        return model + "," + price + "," + quantity + "," + id;
    }
}
