/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenevo
 */
public class Address {

    public Address() {
    }
    private String Street;
    private String City;
    private String State;
    private int ZIP;
    private short UnitNumber;
    private long PhoneNumber;

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
       this.PhoneNumber = Long.parseLong(PhoneNumber);
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = Integer.parseInt(ZIP);
    }

    public short getUnitNumber() {
        return UnitNumber;
    }

    public void setUnitNumber(String UnitNumber) {
       this.UnitNumber = Short.parseShort(UnitNumber);
    }
}
