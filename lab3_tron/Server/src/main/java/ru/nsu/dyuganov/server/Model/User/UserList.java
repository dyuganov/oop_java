package main.java.ru.nsu.dyuganov.server.Model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Stores Set of users id and Map id - UserHandler
 * */
public class UserList {
    private final Map<Integer, UserHandler> usersById;
    private final Set<Integer> usersId;
    private static int idGenerator = 0;

    public UserList(){
        usersById = new HashMap<>(4);
        usersId = new HashSet<>();
    }

    /**
     * Generates id for new user, adds it to id list.
     * Adds user handler to active users map by id.
     * @return added user id
     * */
    public synchronized int add(UserHandler userHandler){
        int newUserId = idGenerator++;
        if(!this.usersById.containsValue(userHandler)){
            this.usersById.put(newUserId, userHandler);
            this.usersId.add(newUserId);
        }
        return newUserId;
    }

    public synchronized UserHandler getUser(int id){
        return this.usersById.get(id);
    }

    public synchronized Set<Integer> getUsersId(){
        return usersId;
    }

    public synchronized void remove(int id){
        usersById.remove(id);
        usersId.remove(id);
    }

    public synchronized void clearAll(){
        this.usersId.clear();
        this.usersById.clear();
    }
}
