package net.ukr.dreamsicle;

import javax.persistence.*;

/**
 * Created by Yura on 01.06.2017.
 */
@Entity
@Table(name = "Cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstCityName", nullable = false)
    private String firstCityName;

    @Column(name = "lastCityName", nullable = false)
    private String lastCityName;

    @Column(name = "distanceBetweenTown", nullable = false)
    private Integer distanceBetweenTown;

    public City() {
    }

    public City(String firstCityName, String lastCityName, Integer distanceBetweenTown) {
        this.firstCityName = firstCityName;
        this.lastCityName = lastCityName;
        this.distanceBetweenTown = distanceBetweenTown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstCityName() {
        return firstCityName;
    }

    public void setFirstCityName(String firstCityName) {
        this.firstCityName = firstCityName;
    }

    public String getLastCityName() {
        return lastCityName;
    }

    public void setLastCityName(String lastCityName) {
        this.lastCityName = lastCityName;
    }

    public Integer getDistanceBetweenTown() {
        return distanceBetweenTown;
    }

    public void setDistanceBetweenTown(Integer distanceBetweenTown) {
        this.distanceBetweenTown = distanceBetweenTown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (firstCityName != null ? !firstCityName.equals(city.firstCityName) : city.firstCityName != null)
            return false;
        if (lastCityName != null ? !lastCityName.equals(city.lastCityName) : city.lastCityName != null) return false;
        return distanceBetweenTown != null ? distanceBetweenTown.equals(city.distanceBetweenTown) : city.distanceBetweenTown == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstCityName != null ? firstCityName.hashCode() : 0);
        result = 31 * result + (lastCityName != null ? lastCityName.hashCode() : 0);
        result = 31 * result + (distanceBetweenTown != null ? distanceBetweenTown.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", firstCityName='" + firstCityName + '\'' +
                ", lastCityName='" + lastCityName + '\'' +
                ", distanceBetweenTown=" + distanceBetweenTown +
                '}';
    }

    public double getCalculate(){
        return getDistanceBetweenTown()*1.3;
    }
}
