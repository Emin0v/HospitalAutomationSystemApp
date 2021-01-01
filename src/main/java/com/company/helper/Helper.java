/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.helper;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author Eminov
 */
public class Helper {

    public static void showMsg(String str) {
        String msg;

        switch (str) {
            case "fill":
                msg = "should not be empty";
                JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.ERROR_MESSAGE);
                break;
            case "success":
                msg = "Process Successful";
                JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "error":
                msg = "Error !!";
                JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                msg = str;
                JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }

    public static boolean confirm(String str) {
        String msg;

        switch (str) {
            case "sure":
                msg = "Are you sure ?";
                break;
            default:
                msg = str;
                break;
        }

        int result = JOptionPane.showConfirmDialog(null, msg, "Attention!!", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void centerWindow(Window frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        
        frame.setMaximumSize(frame.getMaximumSize());
    }

}
