package com.company.model;

/**
 *
 * @author Eminov
 */
public class Doctor extends User{

    public Doctor() {
    }

    public Doctor(Integer id) {
        super(id);
    }

    public Doctor(Integer id, String username, String password, String name, String type) {
        super(id, username, password, name, type);
    }
    
    
}
