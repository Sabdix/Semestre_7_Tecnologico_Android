
package com.Model;

/**
 *
 * @author sabdi
 */
public class Usuario {
    private int id;
    private String nick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String toString() {
        return id + "-" + nick;
    }
}
