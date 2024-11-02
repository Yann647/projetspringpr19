package sn.supinfo.projetexamen.model;

import jakarta.persistence.Entity;

@Entity
public class Agent extends Personne {

    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
