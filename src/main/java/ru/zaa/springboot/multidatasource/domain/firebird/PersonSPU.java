package ru.zaa.springboot.multidatasource.domain.firebird;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "SN")
public class PersonSPU {

    @Id
    private Long id;

    private String sn;
    private String kch;

    @JsonView(ViewPersonSPU.ShortJson.class)
    private String fm;
    @JsonView(ViewPersonSPU.ShortJson.class)
    private String im;
    @JsonView(ViewPersonSPU.ShortJson.class)
    private String ot;

    private LocalDate dtr;

    @JsonView(ViewPersonSPU.ShortJson.class)
    private String pol;

    @Transient
    @JsonView(ViewPersonSPU.ShortJson.class)
    private String dtrStr;

    @Column(name = "COUNTRY_BORN")
    private String countryBorn;

    @Column(name = "DISTRICT_BORN")
    private String districtBorn;

    @Column(name = "REGION_BORN")
    private String regionBorn;

    @Column(name = "D_REG")
    private Date dReg;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }


    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }


    public LocalDate getDtr() {
        return dtr;
    }

    public void setDtr(LocalDate dtr) {
        this.dtr = dtr;
    }


    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }


    public String getCountryBorn() {
        return countryBorn;
    }

    public void setCountryBorn(String countryBorn) {
        this.countryBorn = countryBorn;
    }


    public String getDistrictBorn() {
        return districtBorn;
    }

    public void setDistrictBorn(String districtBorn) {
        this.districtBorn = districtBorn;
    }


    public String getRegionBorn() {
        return regionBorn;
    }

    public void setRegionBorn(String regionBorn) {
        this.regionBorn = regionBorn;
    }


    public java.sql.Date getDReg() {
        return dReg;
    }

    public void setDReg(java.sql.Date dReg) {
        this.dReg = dReg;
    }

    public PersonSPU trim(PersonSPU person) {
        person.setFm(person.getFm().trim());
        person.setIm(person.getIm().trim());
        person.setOt(person.getOt().trim());
        person.setCountryBorn(person.getCountryBorn().trim());
        person.setRegionBorn(person.getRegionBorn().trim());
        person.setDistrictBorn(person.getDistrictBorn().trim());
        return person;
    }

    public PersonSPU trim() {
        fm = fm.trim();
        im = im.trim();
        ot = ot.trim();
        countryBorn = countryBorn.trim();
        regionBorn = regionBorn.trim();
        districtBorn = districtBorn.trim();
        return this;
    }

    public String getDtrStr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dtr.format(formatter);
    }

    public void setDtrStr(String dtrStr) {
        this.dtrStr = dtrStr;
    }
}
