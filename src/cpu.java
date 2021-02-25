package src;

public class cpu extends item
{
    private String model;
    private int quantity;

    public cpu(int _quantity, String _id, String _name, double _price, String _model)
    {
        super(_id, _name, _price);
        model = _model;
        quantity = _quantity;
    }

    public String model()
    {
        return model;
    }

    public int quantity()
    {
        return quantity;
    }
}
