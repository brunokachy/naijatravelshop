package com.naijatravelshop.service.hotel.pojos.request.book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "Guest")
public class Guest {

    private String type;

    private String title;

    private String firstName;

    private String lastName;

    private Integer age;

    private String dateOfBirth;

    @XmlElement(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "Age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlElement(name = "DateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Guest{" + "type=" + type + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", dateOfBirth=" + dateOfBirth + '}';
    }

}

