package src.item;

import java.io.Serializable;

public class gpu implements item, Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 507941469347219168L;
    private String model;
    private double price;
    private boolean gaming;
    private int quantity;
    
    public gpu(String _model, double _price, boolean _gaming, int _quantity)
    {
        model = _model;
        price = _price;
        gaming = _gaming;
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

    public boolean gaming()
    {
        return gaming;
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
        return model + " " + price + " gaming:" + gaming + " ";
    }
}
