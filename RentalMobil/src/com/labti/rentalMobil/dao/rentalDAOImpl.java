/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil.dao;

import com.labti.rentalMobil.model.Rental;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class rentalDAOImpl implements RentalDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Rental rental){
        sessionFactory.getCurrentSession().save(rental);
    }
    
    @Override
    public void update(Rental rental){
        sessionFactory.getCurrentSession().update(rental);
    }
    
    @Override
    public void delete(Rental rental){
        sessionFactory.getCurrentSession().delete(rental);
    }
    
    @Override
    public Rental getRental(String tahun){
        return (Rental) sessionFactory.getCurrentSession().get(Rental.class, tahun);        
    }
    
    @Override
    public List<Rental> getRentals(){
        return sessionFactory.getCurrentSession().createCriteria(Rental.class).list();
    }
}
