package src.account;

public abstract class account {

    String username, password;

    public account(String _username, String _password)
    {
        username = _username;
        password = _password;
    }

    public abstract boolean isAdmin();
    public abstract String getUser();
    public abstract String getPass();
}
