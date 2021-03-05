package src.account;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Login 
{

    //private String username, password;
    public boolean login;
    public account loggedInUser;
    
    public void LogIn(String username, String password)
    {
        // Used to hold the instance of a user who successfully logged in
        account loggedInUser = null;

        // Create an empty list to hold users
        List<account> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new customer("anthony", "12345"));
        listOfUsers.add(new adminAcc("twiet", "qwerty"));

        // Get user input
        // Scanner scan = new Scanner(System.in);

        // System.out.println("Enter your username: ");
        // username = scan.nextLine();   
        // System.out.println("Enter your password: ");
        // password = scan.nextLine();

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
            //LogIn();
        }

        //scan.close();
    }

    public boolean LoggedIn()
    {
        return login;
    }
}
