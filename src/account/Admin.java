package account;

public class Admin extends account{

    private String user, pass;

    public Admin(String username, String password)
    {
        super(username, password);
        
        user = username;
        pass = password;
    }

    @Override
	public String getUser()
    {
        return user;
    }

    @Override
	public String getPass()
    {
        return pass;
    }

    @Override
	public boolean isAdmin()
    {
        return true;
    }
}
