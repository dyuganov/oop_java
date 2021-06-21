package main.java.ru.nsu.dyuganov.tron.Model;

import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserList {
    private final Map<Integer, UserController> usersById;

    private static int idGenerator = 0;

    private final int standardSize = 4;
    private int maxSize = standardSize;

    public UserList() {
        usersById = new HashMap<>(standardSize);
    }

    public UserList(int maxSize) {
        this.maxSize = maxSize;
        usersById = new HashMap<>(standardSize);
    }

    /**
     * @return added user id (positive int)
     */
    public synchronized int add(UserController userController) {
        int newUserId = idGenerator++;
        if (isFull()) {
            throw new RuntimeException("Can't add user to user list. It is full.");
        }
        if (!this.usersById.containsValue(userController)) {
            this.usersById.put(newUserId, userController);
        }
        return newUserId;
    }

    public boolean isFull() {
        return usersById.size() >= maxSize;
    }

    public int getSize() {
        return usersById.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public synchronized UserController getUser(int id) {
        return this.usersById.get(id);
    }


    public synchronized Set<Integer> getUsersId() {
        return usersById.keySet();
    }

    public synchronized void remove(int id) {
        usersById.remove(id);
    }

    public synchronized void clearAll() {
        this.usersById.clear();
    }
}
