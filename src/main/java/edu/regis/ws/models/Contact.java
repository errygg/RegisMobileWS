package edu.regis.ws.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactType")
@XmlRootElement(name = "Contact")
public class Contact {

    protected Integer id;
    protected String firstName;
    protected String lastName;
    protected String title;
    protected String email;
    protected String address;
    protected String city;
    protected String state;
    protected Integer zip;
    protected String busPhone;
    protected String homePhone;
    protected String cellPhone;
    protected String fax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer value) {
        this.zip = value;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String value) {
        this.busPhone = value;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String value) {
        this.homePhone = value;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String value) {
        this.cellPhone = value;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String value) {
        this.fax = value;
	}
}
