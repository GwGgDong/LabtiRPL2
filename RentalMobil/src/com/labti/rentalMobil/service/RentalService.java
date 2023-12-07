/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.service;

import com.labti.rentalMobil.model.Rental;
import java.util.List;

public interface RentalService {
    public void save(Rental rental);
    public void update(Rental rental);
    public void delete(Rental rental);
    public Rental getRental(String npm);
    public List<Rental> getRentals();
}