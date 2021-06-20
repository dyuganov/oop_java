package main.java.ru.nsu.dyuganov.tron.Model;

import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserController;
import main.java.ru.nsu.dyuganov.tron.Model.UserHandler.UserHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Stores Set of users id and Map id - UserHandler
 * */
public class UserList {
    //private final Map<Integer, UserHandler> usersById;
    private final Map<Integer, UserController> usersById;

    private final Set<Integer> usersId;
    private static int idGenerator = 0;

    private final int standardSize = 4;
    private int maxSize = standardSize;

    public UserList (){
        usersById = new HashMap<>(standardSize);
        usersId = new HashSet<>(standardSize);
    }

    public UserList(int maxSize){
        this.maxSize = maxSize;
        usersById = new HashMap<>(standardSize);
        usersId = new HashSet<>(standardSize);
    }

    /**
     * Generates id for new user, adds it to id list.
     * Adds user handler to active users map by id.
     * @return added user id (positive int)
     * */
    /*public synchronized int add(UserHandler userHandler){
        int newUserId = idGenerator++;
        if (isFull()) {
            throw new RuntimeException("Can't add user to user list. It is full.");
        }
        if (!this.usersById.containsValue(userHandler)){
            this.usersById.put(newUserId, userHandler);
            this.usersId.add(newUserId);
        }
        assert usersById.size() == usersId.size();
        return newUserId;
    }*/

    public synchronized int add(UserController userController){
        int newUserId = idGenerator++;
        if (isFull()) {
            throw new RuntimeException("Can't add user to user list. It is full.");
        }
        if (!this.usersById.containsValue(userController)){
            this.usersById.put(newUserId, userController);
            this.usersId.add(newUserId);
        }
        assert usersById.size() == usersId.size();
        return newUserId;
    }

    public boolean isFull(){
        return usersId.size() >= maxSize;
    }

    public int getSize(){
        assert usersById.size() == usersId.size();
        return usersId.size();
    }

    public int getMaxSize(){
        return maxSize;
    }

    /*public synchronized UserHandler getUser(int id){
        return this.usersById.get(id);
    }*/

    public synchronized UserController getUser(int id){
        return this.usersById.get(id);
    }


    public synchronized Set<Integer> getUsersId(){
        return usersId;
    }

    public synchronized void remove(int id){
        usersById.remove(id);
        usersId.remove(id);
        assert usersById.size() == usersId.size();
    }

    public synchronized void clearAll(){
        this.usersId.clear();
        this.usersById.clear();
        assert usersById.size() == usersId.size();
    }
}
