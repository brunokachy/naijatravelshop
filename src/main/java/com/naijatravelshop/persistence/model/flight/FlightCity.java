package com.naijatravelshop.persistence.model.flight;

import com.naijatravelshop.persistence.model.portal.Country;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "flight_city")
public class FlightCity implements Serializable {
    private String name;
    private Integer popularityIndex;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(Integer popularityIndex) {
        this.popularityIndex = popularityIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
