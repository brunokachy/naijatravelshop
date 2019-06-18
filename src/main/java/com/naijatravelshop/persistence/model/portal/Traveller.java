package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.AgeGroupType;
import com.naijatravelshop.persistence.model.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "traveller")
public class Traveller implements Serializable {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Timestamp dateOfBirth;
    private AgeGroupType ageGroup;
    private String title;
    private Integer age;
    private String middleName;
    private Gender gender;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Reservation reservation;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AgeGroupType getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroupType ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
