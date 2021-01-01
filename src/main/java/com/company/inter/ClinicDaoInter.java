package com.company.inter;

import com.company.model.Clinic;
import com.company.model.User;
import java.util.ArrayList;

/**
 *
 * @author Eminov
 */
public interface ClinicDaoInter {
    
    public ArrayList<Clinic> getList();
    
    public ArrayList<User> getClinicDoctorList(int clinic_id);
    
    public Clinic getFetch(Integer id);
    
    public boolean addClinic(String name);
    
    public boolean deleteClinic(Integer id);
    
    public boolean updateClinic(Integer id , String name );
}
