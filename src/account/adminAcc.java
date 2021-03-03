package src.account;

public class adminAcc extends account{

    private String user, pass;

    public adminAcc(String username, String password)
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

    public boolean admin()
    {
        return true;
    }
}
