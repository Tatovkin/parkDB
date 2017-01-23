package by.academy.it.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PLANT_ID")
public class Bush extends Plant {

    private static final long serialVersionUID = 1L;

    private String crown;

    public String getCrown() {
        return crown;
    }

    public void setCrown(String crown) {
        this.crown = crown;
    }
}
