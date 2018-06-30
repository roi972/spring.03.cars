package com.example.cars;

import javax.persistence.*;

@Entity
@Table(name="Cars")
@NamedQueries({
                @NamedQuery(name = "CarGetByRegistration",
                        query = "SELECT c from Car as c WHERE c.registration = :registration"),

                @NamedQuery(name = "CarFindAll",
                        query = "SELECT c from Car as c"),

                @NamedQuery(name = "CarGetAllByColor",
                        query = "SELECT c from Car as c WHERE c.colorType = :colorType")
})
public class Car {
    private String registration;
    private String make;
    private ColorType colorType;


    @Id
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Enumerated(value = EnumType.ORDINAL)
    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public Car() {
    }

    public Car(String registration, String make, ColorType colorType) {
        this.registration = registration;
        this.make = make;
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registration='" + registration + '\'' +
                ", make='" + make + '\'' +
                ", colorType=" + colorType +
                '}';
    }
}
