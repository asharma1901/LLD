package Inventory_OrderManagement;

import java.util.List;

public class UserController {

    List<User> users;

    UserController(List users){
        this.users = users;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public void removeUser(User user)
    {
        users.remove(user);
    }

    public List<User> getUsers()
    {
        return  users;
    }

    public User getUserFromUserID(int userId)
    {
        for(User user: users)
        {
            if(user.userId == userId){
                return user;
            }
        }

        return null;
    }
}
