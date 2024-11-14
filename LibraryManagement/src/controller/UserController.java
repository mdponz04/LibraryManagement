package controller;


import model.User;
import view.UserView;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class UserController {
    private int idCounter;
    private static final String FILE_NAME = "src/users.dat";
    private UserView view = new UserView();
    private HashMap<String, User> users = new HashMap();

    private String generateId(){
        idCounter++;
        return String.format("U%05d", idCounter);
    }
    public User findUser(String id){
        for(String userId : users.keySet()){
            if(userId.equals(id)){
                return users.get(id);
            }
        }
        return null;
    }
    private LocalDate convertStringToDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(stringDate, formatter);


            String reconstructedDateString = date.format(formatter);
            if (!stringDate.equals(reconstructedDateString)) {
                throw new DateTimeParseException("Invalid date", stringDate, 0);
            }

            return date;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format or value for input: " + stringDate);
            return null;
        }
    }
    //3.1 Add a user
    public void createUser(String name, String dateOfBirth, String phoneNumber, String email){
        if(convertStringToDate(dateOfBirth) == null){
            return;
        }
        User user = new User(generateId(), name, convertStringToDate(dateOfBirth), phoneNumber, email);
        users.put(user.getId(), user);
    }
    //3.2 Update user information
    public void updateUser(String id, String name, String dateOfBirth, String phoneNumber, String email){
        User updatedUser = findUser(id);
        if(!name.isEmpty()){
            updatedUser.setName(name);
        }
        if(convertStringToDate(dateOfBirth) != null){
            updatedUser.setDateOfBirth(convertStringToDate(dateOfBirth));
        }
        if(!phoneNumber.isEmpty()){
            updatedUser.setPhoneNumber(phoneNumber);
        }
        if(!email.isEmpty()){
            updatedUser.setEmail(email);
        }

    }
    //3.3 Delete a user
    public void deleteUser(String id){
        findUser(id).setActiveUser(false);
        showActiveUser();
    }

    public void showAllUser(){
        view.printUserList(users);
    }
    public void showUserDetails(User user){
        view.printUserDetails(user);
    }

    public void save(){

        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(users);
            oos.writeObject(idCounter);

            oos.close();
            fos.close();
            System.out.println("Events list save successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving events list to file. ");
            e.printStackTrace();
        }
    }
    public void load(){
        try{
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            users = (HashMap<String, User>) ois.readObject();
            idCounter = (int) ois.readObject();
            view.printUserList(users);

            ois.close();
            fis.close();
        }catch (IOException e){
            System.err.println("Error loading events list from file. System end!!!");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error loading file. System end!!!");
            ex.printStackTrace();
        }
    }
    private void showActiveUser(){
        HashMap<String, User> activeUsers = new HashMap();
        for(User u : users.values().stream().toList()){
            if(u.isActiveUser()){
                activeUsers.put(u.getId(), u);
            }
        }

        view.printUserList(activeUsers);
    }
}
