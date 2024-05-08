package com.isicod.net.springCas.models;

import java.util.List;
import java.util.Map;

public class CasUser {

    private String uid;

    private String supannOrganisme;

    private String supannEtuId;

    private String supannCodeINE;

    private String supannAliasLogin;

    private String sn;

    private String mail;

    private String givenName;

    private String filiere;

    private String etab;

    private String eduPersonPrincipalName;

    private String eduPersonPrimaryAffiliation;

    private List<String> eduPersonAffiliation;

    private String displayName;

    private String commonName;

    private String cne;

    private String cin;

    public CasUser() {
    }
    public CasUser(Map<String, Object> attributes) {
        this.uid = (String) attributes.get("uid");
        this.supannOrganisme = (String) attributes.get("supannOrganisme");
        this.supannEtuId = (String) attributes.get("supannEtuId");
        this.supannCodeINE = (String) attributes.get("supannCodeINE");
        this.supannAliasLogin = (String) attributes.get("supannAliasLogin");
        this.sn = (String) attributes.get("sn");
        this.mail = (String) attributes.get("mail");
        this.givenName = (String) attributes.get("givenName");
        this.filiere = (String) attributes.get("filiere");
        this.etab = (String) attributes.get("etab");
        this.eduPersonPrincipalName = (String) attributes.get("eduPersonPrincipalName");
        this.eduPersonPrimaryAffiliation = (String) attributes.get("eduPersonPrimaryAffiliation");
        this.eduPersonAffiliation = (List<String>) attributes.get("eduPersonAffiliation");
        this.displayName = (String) attributes.get("displayName");
        this.commonName = (String) attributes.get("commonName");
        this.cne = (String) attributes.get("cne");
        this.cin = (String) attributes.get("cin");
    }

    // Use lombok instead
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSupannOrganisme() {
        return supannOrganisme;
    }

    public void setSupannOrganisme(String supannOrganisme) {
        this.supannOrganisme = supannOrganisme;
    }

    public String getSupannEtuId() {
        return supannEtuId;
    }

    public void setSupannEtuId(String supannEtuId) {
        this.supannEtuId = supannEtuId;
    }

    public String getSupannCodeINE() {
        return supannCodeINE;
    }

    public void setSupannCodeINE(String supannCodeINE) {
        this.supannCodeINE = supannCodeINE;
    }

    public String getSupannAliasLogin() {
        return supannAliasLogin;
    }

    public void setSupannAliasLogin(String supannAliasLogin) {
        this.supannAliasLogin = supannAliasLogin;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }

    public String getEduPersonPrincipalName() {
        return eduPersonPrincipalName;
    }

    public void setEduPersonPrincipalName(String eduPersonPrincipalName) {
        this.eduPersonPrincipalName = eduPersonPrincipalName;
    }

    public String getEduPersonPrimaryAffiliation() {
        return eduPersonPrimaryAffiliation;
    }

    public void setEduPersonPrimaryAffiliation(String eduPersonPrimaryAffiliation) {
        this.eduPersonPrimaryAffiliation = eduPersonPrimaryAffiliation;
    }

    public List<String> getEduPersonAffiliation() {
        return eduPersonAffiliation;
    }

    public void setEduPersonAffiliation(List<String> eduPersonAffiliation) {
        this.eduPersonAffiliation = eduPersonAffiliation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
