package com.naijatravelshop.service.hotel.pojos.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "LoginDetails")
public class JacTravelApiCredential {
    private String login;

    private String password;

    private String locale;

    private Integer currencyID;

    private String agentReference;

    @XmlElement(name = "Login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlElement(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "Locale")
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @XmlElement(name = "CurrencyID")
    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    @XmlElement(name = "AgentReference")
    public String getAgentReference() {
        return agentReference;
    }

    public void setAgentReference(String agentReference) {
        this.agentReference = agentReference;
    }
}
