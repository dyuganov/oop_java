package main.java.ru.nsu.dyuganov.server.Model.User;

import java.util.Objects;

public class User {
    private int id = 0;

    User(int id){
        this.id = id;
    }

    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
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
