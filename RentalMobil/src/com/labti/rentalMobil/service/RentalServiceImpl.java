/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.service;

import com.labti.rentalMobil.model.Rental;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.labti.rentalMobil.dao.RentalDAO;

@Service("RentalService")
@Transactional(readOnly = true)

public class RentalServiceImpl implements RentalService {
    @Autowired
    private RentalDAO rentalDao;
    
    @Transactional
    @Override
    public void save(Rental rental){
        rentalDao.save(rental);
    }
    
    @Transactional
    @Override
    public void update(Rental rental){
        rentalDao.update(rental);
    }
    
    @Transactional
    @Override
    public void delete(Rental rental){
        rentalDao.delete(rental);
    }
    
    @Override
    public Rental getRental(String npm){
        return rentalDao.getRental(npm);
    }
    
    @Override
    public List<Rental> getRentals(){
        return rentalDao.getRentals();
    }
}