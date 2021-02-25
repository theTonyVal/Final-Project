package src;

public abstract class item
{
    private String name;
    private int id;
    private double price;

    public item (int _id, String _name, double _price)
    {
        name = _name;
        id = _id;
        price = _price;
    }

    public String toString()
    {
        //String result = "id: " + id + " name: " + name + " price: " + price;
        String result = id + " " + name + " " + price;
        return result;
    }

    public abstract String model();
    public abstract int quantity();
}