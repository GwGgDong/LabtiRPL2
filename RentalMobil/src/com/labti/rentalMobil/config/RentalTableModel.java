/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.config;

import com.labti.rentalMobil.model.Rental;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RentalTableModel extends AbstractTableModel {
    private List<Rental> rentals = new ArrayList<>();
    private final String HEADER[] = {"tahun","nama","merk","deskripsi"};
    
    public RentalTableModel(List<Rental> mahasiswas){
        this.rentals = mahasiswas;
    }
    
    @Override
    public int getRowCount(){
        return rentals.size();
    }
    
    @Override
    public int getColumnCount(){
        return HEADER.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rental rental = rentals.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rental.getTahun();
            case 1:
                return rental.getNama();
            case 2:
                return rental.getMerk();
            case 3:
                return rental.getDeskripsi();
            default:
                return null;
        }
    }
}