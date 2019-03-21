package ru.zaa.springboot.multidatasource.domain.firebird;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="SN")
public class PersonSPU {

    @Id
    private Long id;

    private String sn;
    private String kch;
    private String fm;
    private String im;
    private String ot;
    private Date dtr;
    private String pol;

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


    public java.sql.Date getDtr() {
        return dtr;
    }

    public void setDtr(java.sql.Date dtr) {
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

}
