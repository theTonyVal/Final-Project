package src.item;

import java.io.Serializable;

public class ram implements item, Serializable{
    
    private String model;
    private double price;
    private double mHz;
    private int quantity;
    
    public ram(String _model, double _price, double _mHz, int _quantity)
    {
        model = _model;
        price = _price;
        mHz = _mHz;
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

    public double mHz()
    {
        return mHz;
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
        return model + " " + price + " mHz:" + mHz + " ";
    }

}
