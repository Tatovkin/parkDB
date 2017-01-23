package by.academy.it.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
@DynamicInsert
@DynamicUpdate
public class Tree extends Plant {

    private static final long serialVersionUID = 1L;

    private String crown;
    private Trunk trunk;

    public String getCrown() {
        return crown;
    }

    public void setCrown(String crown) {
        this.crown = crown;
    }

    public Trunk getTrunk() {
        return trunk;
    }

    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }
}
