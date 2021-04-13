package src.account;

public abstract class Account {

    String username, password;

    public Account(String _username, String _password)
    {
        username = _username;
        password = _password;
    }

    public abstract boolean isAdmin();
    public abstract String getUser();
    public abstract String getPass();
}
