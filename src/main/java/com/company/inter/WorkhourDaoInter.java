package com.company.inter;

import com.company.model.Workhour;
import java.util.ArrayList;

/**
 *
 * @author Eminov
 */
public interface WorkhourDaoInter {

    public ArrayList<Workhour> getWorkhourList(int doctor_id);

    public boolean updatePassiveWorkhourStatus(int doctor_id, String date);

    public boolean updateActiveWorkhourStatus(int doctor_id, String date);
}
