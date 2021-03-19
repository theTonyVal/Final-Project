package item;

import java.io.Serializable;

public class cpu implements item, Serializable
{   
    /**
     *
     */
    private static final long serialVersionUID = -4403288843703007447L;
    private String model;
    private double price;
    private int threads;
    private int quantity;

    public cpu(String _model, double _price, int _threads, int _quantity)
    {
        model = _model;
        price = _price;
        threads = _threads;
        quantity = _quantity;
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

    public int threads()
    {
        return threads;
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

    @Override
	public String toString()
    {
        return model + " " + price + " threads:" + threads + " ";
    }
}
