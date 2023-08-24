package entity;

import java.io.Serializable;

public class Joueur extends Entity {
    public String name;
    public Joueur(String name, int health, int damage) {
        super(health, damage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
