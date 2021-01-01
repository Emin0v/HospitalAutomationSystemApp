/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.inter;

import com.company.impl.AppointmentDaoImpl;
import com.company.impl.ClinicDaoImpl;
import com.company.impl.DoctorDaoImpl;
import com.company.impl.PatientDaoImpl;
import com.company.impl.SurgeonDaoImpl;
import com.company.impl.WorkhourDaoImpl;

/**
 *
 * @author Eminov
 */
public class Context {

    public static PatientDaoInter instancePatientDao() {
        return new PatientDaoImpl();
    }

    public static SurgeonDaoInter instanceSurgeonDao() {
        return new SurgeonDaoImpl();
    }

    public static ClinicDaoInter instanceClinicDao() {
        return new ClinicDaoImpl();
    }

    public static DoctorDaoInter instanceDoctorDao() {
        return new DoctorDaoImpl();
    }
    
    public static WorkhourDaoInter instanceWorkhourDao() {
        return new WorkhourDaoImpl();
    }
    
    public static AppointmentDaoInter instanceAppointmentDao() {
        return new AppointmentDaoImpl();
    }
}
