package src.item;

public class cpu implements item
{
    private String model;
    private int quantity;
    private double price;

    public cpu(String _model, double _price, int _quantity)
    {
        model = _model;
        price = _price;
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

    public int quantity()
    {
        return quantity;
    }

}
