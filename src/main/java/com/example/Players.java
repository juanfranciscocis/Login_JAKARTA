package com.example;


/**
 *
 * @author Leonard
 */
public class Players {
    private String player;
    private byte age;
    private String birthplace;


    public Players(String player, byte age, String birthplace) {
        this.player = player;
        this.age = age;
        this.birthplace = birthplace;
    }        

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

}