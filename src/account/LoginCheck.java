package src.account;

import java.util.ArrayList;
import java.util.List;

//Checks if the User has an account. Will also check if the user is a customer or admin.
public class LoginCheck 
{

    public boolean loginAdmin = false;
    public boolean loginCust = false;
    public account loggedInUser;
    
    public void LoginAuth(String username, String password)
    {
        // Used to hold the instance of a user who successfully logged in
        account loggedInUser = null;

        // Create an empty list to hold users
        List<account> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new Admin("anthony", "12345"));
        listOfUsers.add(new Admin("twiet", "qwerty"));
        listOfUsers.add(new customer("test", "1"));

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
        if (loggedInUser != null && loggedInUser.isAdmin())
        {
        	loginAdmin = true;
            System.out.println("User successfully logged in: "+ loggedInUser.getUser());
        }
        else if (loggedInUser != null && !loggedInUser.isAdmin())
        {
        	loginCust = true;
        }
        else
        {
            System.out.println("Invalid username/password combination");
        }

    }

    public boolean LoggedInAdmin()
    {
        return loginAdmin;
    }
    
    public boolean LoggedInCust()
    {
    	return loginCust;
    }
}
