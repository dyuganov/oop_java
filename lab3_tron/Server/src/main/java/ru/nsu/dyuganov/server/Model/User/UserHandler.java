package main.java.ru.nsu.dyuganov.server.Model.User;

import java.util.Objects;

public class UserHandler {
    private int id = 0;

    UserHandler(int id){
        this.id = id;
    }

    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHandler user = (UserHandler) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User(" + "id=" + id + ')';
    }
}
