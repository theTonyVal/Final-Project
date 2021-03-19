package src.item;

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

    public String model()
    {
        return model;
    }

    public double price()
    {
        return price;
    }

    public int threads()
    {
        return threads;
    }

    public int quantity()
    {
        return quantity;
    }

    public void sell()
    {
        quantity -= 1;
    }

    public String toString()
    {
        return model + " " + price + " threads:" + threads + " ";
    }
}
