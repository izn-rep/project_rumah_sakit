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
public class TarifBayarModel {
    
    private String kodebayar;
    private String nama_kamar;
    private double tarif;
    private String kelas;

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKodebayar() {
        return kodebayar;
    }

    public void setKodebayar(String kodebayar) {
        this.kodebayar = kodebayar;
    }

    public String getNama_kamar() {
        return nama_kamar;
    }

    public void setNama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TarifBayarModel other = (TarifBayarModel) obj;
        if (!Objects.equals(this.nama_kamar, other.nama_kamar)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tarif) != Double.doubleToLongBits(other.tarif)) {
            return false;
        }
        if (!Objects.equals(this.kelas, other.kelas)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.kodebayar);
        return hash;
    }
    
    
    
}
