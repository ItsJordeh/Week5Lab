/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class AccountService {

    private User abe = new User("abe", "password");
    private User barb = new User("barb", "password");

    public User login(String username, String password) {

        User user = null;

        if ((username.equals(abe.getUsername()) && password.equals(abe.getPassword())) || (username.equals(barb.getUsername()) && password.equals(barb.getPassword()))) {
            user = new User(username, null);
        }

        return user;

    }

}
