package src.account;

public class customer extends account{

    private String user, pass;

    public customer(String username, String password)
    {
        super(username, password);
        
        user = username;
        pass = password;
    }

    public String getUser()
    {
        return user;
    }

    public String getPass()
    {
        return pass;
    }

    public boolean isAdmin()
    {
        return false;
    }
    
}
