package main.java.ru.nsu.dyuganov.server.Model.User;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class UserList {
    private Map<Integer, UserHandler> activeUsersById;
    private Set<Integer> activeUsersId;
    private static int idGenerator = 0;

    UserList(){
        activeUsersById = new ConcurrentHashMap<>();
        activeUsersId = new ConcurrentSkipListSet<>();
    }

    /**
     * Generates id for new user, adds it to id list.
     * Adds user handler to active users map by id.
     * @return added user id
     * */
    public synchronized int addUser(UserHandler userHandler){
        int newUserId = idGenerator++;
        if(!this.activeUsersById.containsValue(userHandler)){
            this.activeUsersById.put(newUserId, userHandler);
            this.activeUsersId.add(newUserId);
        }
        return newUserId;
    }

    public synchronized UserHandler getUser(int id){
        return this.activeUsersById.get(id);
    }

    public synchronized Set<Integer> getActiveUsersId(){
        return activeUsersId;
    }
}
