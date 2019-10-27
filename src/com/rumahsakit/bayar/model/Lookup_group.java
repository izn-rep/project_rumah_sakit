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
public class Lookup_group {
    
    private String Lookup_group;
    private Integer status;

    public Lookup_group(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getLookup_group() {
        return Lookup_group;
    }

    public void setLookup_group(String Lookup_group) {
        this.Lookup_group = Lookup_group;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lookup_group other = (Lookup_group) obj;
        if (!Objects.equals(this.Lookup_group, other.Lookup_group)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Lookup_group);
        return hash;
    }
    
}
