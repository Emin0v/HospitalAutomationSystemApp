package com.company.inter;

import com.company.model.User;
import java.util.ArrayList;

/**
 *
 * @author Eminov
 */
public interface SurgeonDaoInter {
    
    public ArrayList<User> getDoctorList();
    
    public ArrayList<User> getClinicDoctorList(int clinic_id); 
    
    public boolean addDoctor(String username , String password , String name );
    
    public boolean deleteDoctor(Integer id);
    
    public boolean updateDoctor(Integer id , String username , String password , String name );
    
    public boolean addWorker(int user_id, int clinic_id);
    
}
