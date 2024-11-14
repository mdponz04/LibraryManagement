package view;


import model.User;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;


public class UserView {

    public void printUserDetails(User user){
        if(user == null){
            System.out.println("This user is not exist!!!");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("-------User Details-------");
        // Print the table headers
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , "ID", "Name", "Date of birth", "Phone number", "Email", "Active user");
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , user.getId(), user.getName(), user.getDateOfBirth().format(formatter), user.getPhoneNumber()
                , user.getEmail(), user.isActiveUser());

    }

    public void printUserList(HashMap<String, User> users){
        if(users.isEmpty()){
            System.out.println("There is no user!!!");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("-------User list-------");
        System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                , "ID", "Name", "Date of birth", "Phone number", "Email", "Active user");

        Iterator<User> userIterator = users.values().iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            System.out.printf("%-7s|%-20s|%-20s|%-20s|%-20s|%-20s|\n"
                    , user.getId(), user.getName(), user.getDateOfBirth().format(formatter)
                    , user.getPhoneNumber(), user.getEmail(), user.isActiveUser());

        }
    }
}
