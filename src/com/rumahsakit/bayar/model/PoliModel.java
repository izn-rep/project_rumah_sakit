/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.model;

import java.util.Objects;

/**
 *
 * @author General Bassamtiano
 */
public class PoliModel {
    
    private String kodepoli;
    private String namapoli;

    public String getKodepoli() {
        return kodepoli;
    }

    public void setKodepoli(String kodepoli) {
        this.kodepoli = kodepoli;
    }

    public String getNamapoli() {
        return namapoli;
    }

    public void setNamapoli(String namapoli) {
        this.namapoli = namapoli;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PoliModel other = (PoliModel) obj;
        if (!Objects.equals(this.kodepoli, other.kodepoli)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.kodepoli);
        return hash;
    }
    
    
    
}
