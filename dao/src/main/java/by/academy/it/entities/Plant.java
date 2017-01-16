package by.academy.it.entities;

import javax.persistence.*;

@Entity
@Table
public class Plant {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer serialNumber;
    @Column
    private String type;
    @Column
    private Double longitude;
    @Column
    private Double latitude;

    public Plant() {
    }

    public Plant(Integer id, Integer serialNumber, String type, Double longitude, Double latitude) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Plant)) return false;

        Plant plant = (Plant) obj;

        if (!id.equals(plant.id)) return false;
        if (!serialNumber.equals(plant.serialNumber)) return false;
        if (!type.equals(plant.type)) return false;
        if (!longitude.equals(plant.longitude)) return false;
        if (!latitude.equals(plant.latitude)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plant : id: " + id + " ser.№: " + serialNumber + " type: " + type +
                " Longitude: " + longitude + " Latitude: " + latitude;
    }
}
