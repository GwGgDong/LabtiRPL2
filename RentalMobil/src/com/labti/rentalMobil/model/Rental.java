/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "rental")
@Entity
public class Rental {
    @Id
    @Column(name = "tahun", length = 8)
    private String tahun;
    
    @Column(name = "nama", length = 50)
    private String nama;
    
    @Column(name = "merk", length = 50)
    private String merk;
    
    @Column(name = "deskripsi", length = 50)
    private String deskripsi;
    
    public String getTahun(){
        return tahun;
    }
    public void setTahun(String tahun){
        this.tahun = tahun;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getMerk(){
        return merk;
    }
    public void setMerk(String merk){
        this.merk = merk;
    }
    
    public String getDeskripsi(){
        return deskripsi;
    }
    
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
}