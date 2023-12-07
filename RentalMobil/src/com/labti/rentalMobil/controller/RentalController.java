/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.controller;

import com.labti.rentalMobil.app;
import com.labti.rentalMobil.config.RentalTableModel;
import com.labti.rentalMobil.model.Rental;
import com.labti.rentalMobil.view.RentalView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class RentalController {
    private final RentalView rentalView;
    private RentalTableModel rentalTableModel;
    private List<Rental> rentals;
    
    public RentalController (RentalView rentalView){
        this.rentalView = rentalView;
    }
    
    public void tampilData(){
        rentals = app.getRentalService().getRentals();
        rentalTableModel = new RentalTableModel(rentals);
        this.rentalView.getTabel().setModel((TableModel) rentalTableModel);
    }
    
    public void show(){
        int index = this.rentalView.getTabel().getSelectedRow();
        this.rentalView.getNpm().setText(String.valueOf(
        this.rentalView.getTabel().getValueAt(index, 0)));
        this.rentalView.getNama().setText(String.valueOf(
        this.rentalView.getTabel().getValueAt(index, 1)));
        this.rentalView.getMerk().setText(String.valueOf(
        this.rentalView.getTabel().getValueAt(index, 2)));
        this.rentalView.getDeskripsi().setText(String.valueOf(
        this.rentalView.getTabel().getValueAt(index, 3)));
    }
    
    public void clear(){
        this.rentalView.getNpm().setText("");
        this.rentalView.getNama().setText("");
        this.rentalView.getMerk().setText("");
        this.rentalView.getDeskripsi().setText("");
    }
    
    public void saveRental(){
        Rental rental = new Rental();
        rental.setTahun(this.rentalView.getNpm().getText());
        rental.setNama(this.rentalView.getNama().getText());
        rental.setMerk(this.rentalView.getMerk().getText());
        rental.setDeskripsi(this.rentalView.getDeskripsi().getText());
        app.getRentalService().save(rental);
        JOptionPane.showMessageDialog(null, "Data Berhasil di simpan", "info",
                JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void updateRental(){
        Rental rental = new Rental();
        rental.setTahun(this.rentalView.getNpm().getText());
        rental.setNama(this.rentalView.getNama().getText());
        rental.setMerk(this.rentalView.getMerk().getText());
        rental.setDeskripsi(this.rentalView.getDeskripsi().getText());
        app.getRentalService().update(rental);
        JOptionPane.showMessageDialog(null, "Data berhasil di Edit", "info",
                JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteRental(){
        if(this.rentalView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "mobil belum dipilih","error",JOptionPane.ERROR_MESSAGE);
        }else{
            Rental rental = new Rental();
            rental.setTahun(this.rentalView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data ingin dihapus ?", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION){
                app.getRentalService().delete(rental);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus","info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}