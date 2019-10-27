/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.model;

/**
 *
 * @author General Bassamtiano
 */
public class Lookup {
    
    private String Lookup_group;
    private String value;
    private Integer status;
    private String kode_character;

    public String getLookup_group() {
        return Lookup_group;
    }

    public void setLookup_group(String Lookup_group) {
        this.Lookup_group = Lookup_group;
    }

    public String getKode_character() {
        return kode_character;
    }

    public void setKode_character(String kode_character) {
        this.kode_character = kode_character;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value;
    }
    
}
