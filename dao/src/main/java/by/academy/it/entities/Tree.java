package by.academy.it.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "PLANT_ID")
@DynamicInsert
@DynamicUpdate
public class Tree extends Plant {

    private static final long serialVersionUID = 1L;

    private String crown;
    private Trunk trunk;

}
