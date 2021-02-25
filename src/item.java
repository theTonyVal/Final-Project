package src;

public abstract class item
{
    private String name;
    private String id;
    private double price;

    public item (String _id, String _name, double _price)
    {
        name = _name;
        id = _id;
        price = _price;
    }

    public String toString()
    {
        //String result = "id: " + id + " name: " + name + " price: " + price;
        String result = quantity() + " " + id + " " + name + " " + price + " " + model();
        return result;
    }

    public abstract String model();
    public abstract int quantity();
}