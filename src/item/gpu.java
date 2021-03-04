package src.item;

import java.io.Serializable;

public class gpu implements item, Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String model;
    private double price;
    private boolean raytrace;
    private int quantity;
    
    public gpu(String _model, double _price, boolean _raytrace, int _quantity)
    {
        model = _model;
        price = _price;
        raytrace = _raytrace;
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

    public boolean raytrace()
    {
        return raytrace;
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
        return model + " " + quantity;
    }
}
