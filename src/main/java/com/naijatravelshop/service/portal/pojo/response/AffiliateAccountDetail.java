package com.naijatravelshop.service.portal.pojo.response;

/**
 * Created by Bruno on
 * 23/05/2019
 */
public class AffiliateAccountDetail {

    private String publicKey;

    private String secretKey;

    private String affiliateCode;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAffiliateCode() {
        return affiliateCode;
    }

    public void setAffiliateCode(String affiliateCode) {
        this.affiliateCode = affiliateCode;
    }
}
