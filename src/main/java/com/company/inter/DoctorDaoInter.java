/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.inter;

/**
 *
 * @author Eminov
 */
public interface DoctorDaoInter {
    
    public boolean addWhour(int doctor_id , String doctor_name , String wdate);
    
    public boolean deleteWhour(Integer id);
    
}
