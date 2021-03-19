package account;

import java.util.ArrayList;
import java.util.List;

public class LoginCheck 
{

    //private String username, password;
    public boolean login;
    public account loggedInUser;
    
    public void LoginAuth(String username, String password)
    {
        // Used to hold the instance of a user who successfully logged in
        account loggedInUser = null;

        // Create an empty list to hold users
        List<account> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new customer("anthony", "12345"));
        listOfUsers.add(new Admin("twiet", "qwerty"));

        // Iterate through list of users to see if we have a match
        for (account user : listOfUsers)
        {
            if (user.getUser().equals(username))
            {
                if (user.getPass().equals(password))
                {
                    loggedInUser = user;

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            login = true;
            System.out.println("User successfully logged in: "+ loggedInUser.getUser());
            LoggedIn();
        }
        else
        {
            System.out.println("Invalid username/password combination");
        }

    }

    public boolean LoggedIn()
    {
        return login;
    }
}
