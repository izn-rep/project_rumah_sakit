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
public class RumahSakitModel {
    
    private String no_pasien;
    private String nama;
    private String jkelamin;
    private String kodepoli;
    private String kodebayar;
    private double tarif;
    private String nama_kamar;
    private String kelas;
    private int lama;
    private double biayaperawatan;
    private double totalbayar;

    public double getBiayaperawatan() {
        return biayaperawatan;
    }

    public void setBiayaperawatan(double biayaperawatan) {
        this.biayaperawatan = biayaperawatan;
    }

    public String getJkelamin() {
        return jkelamin;
    }

    public void setJkelamin(String jkelamin) {
        this.jkelamin = jkelamin;
    }

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

    public String getKodepoli() {
        return kodepoli;
    }

    public void setKodepol(String kodepoli) {
        this.kodepoli = kodepoli;
    }

    public int getLama() {
        return lama;
    }

    public void setLama(int lama) {
        this.lama = lama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_kamar() {
        return nama_kamar;
    }

    public void setNama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }

    public String getNo_pasien() {
        return no_pasien;
    }

    public void setNo_pasien(String no_pasien) {
        this.no_pasien = no_pasien;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public double getTotalbayar() {
        return totalbayar;
    }

    public void setTotalbayar(double totalbayar) {
        this.totalbayar = totalbayar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RumahSakitModel other = (RumahSakitModel) obj;
        if (!Objects.equals(this.no_pasien, other.no_pasien)) {
            return false;
        }
        if (!Objects.equals(this.kodepoli, other.kodepoli)) {
            return false;
        }
        if (!Objects.equals(this.kodebayar, other.kodebayar)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tarif) != Double.doubleToLongBits(other.tarif)) {
            return false;
        }
        if (!Objects.equals(this.nama_kamar, other.nama_kamar)) {
            return false;
        }
        if (!Objects.equals(this.kelas, other.kelas)) {
            return false;
        }
        if (this.lama != other.lama) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.no_pasien);
        hash = 29 * hash + Objects.hashCode(this.kodepoli);
        hash = 29 * hash + Objects.hashCode(this.kodebayar);
        return hash;
    }
    
    
    
}
