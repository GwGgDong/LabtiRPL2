/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.rentalMobil;

import com.labti.rentalMobil.view.RentalView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.labti.rentalMobil.service.RentalService;

public class app {

    private static ApplicationContext applicationContext;
    
    public static void main(String[] args){
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
        new RentalView().setVisible(true);
    }
    
    public static RentalService getRentalService(){
        return(RentalService)applicationContext.getBean("RentalService");
    }
    
}