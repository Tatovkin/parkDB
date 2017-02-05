package by.academy.it.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "PLANT_ID")
public class Bush extends Plant {

    private static final long serialVersionUID = 1L;

    @Column(name = "CROWN")
    private String crown;

    public String getCrown() {
        return crown;
    }

    public void setCrown(String crown) {
        this.crown = crown;
    }
}
