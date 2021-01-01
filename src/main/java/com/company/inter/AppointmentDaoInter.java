package com.company.inter;

import com.company.model.Appointment;
import java.util.ArrayList;

/**
 *
 * @author Eminov
 */
public interface AppointmentDaoInter {

    public ArrayList<Appointment> getPatientList(int patient_id);
    
    public ArrayList<Appointment> getDoctorList(int doctor_id);

    public boolean addAppointment(int doctor_id, int patient_id, String app_date);

    public boolean deleteAppointment(int id);

    public Appointment getList(int id);

}
