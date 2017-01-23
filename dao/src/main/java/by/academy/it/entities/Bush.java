package by.academy.it.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
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
