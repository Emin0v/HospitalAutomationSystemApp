/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

/**
 *
 * @author Eminov
 */
public class Patient extends User{
    private Integer id;
    private String name ;
    private String username;
    private String password;

    public Patient(){};
    
    public Patient(Integer id, String username, String password, String name, String type) {
        super(id, username, password, name, type);
    }
    
    
    
}
