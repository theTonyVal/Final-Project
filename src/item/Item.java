package src.item;

//The interface for items. Implemented into every item for polymorphism.
public interface Item
{	
    public void setModel(String newModel);
    public void setQuantity(int newQuantity);
    public void setPrice(double newPrice);
    public void  setId(String newID);
    
    public String getModel();
    public int getQuantity();
    public double getPrice();
    public String getId();
    
    public String csvString();
    public void sell();
}