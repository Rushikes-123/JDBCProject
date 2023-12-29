package com.Assigment;
//4. Create a HashMap with docid as key and list of patients treated by that
//doctor as value. Show all entries in HashMap.


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.Assigment.jdbc.MyConnection;

public class DoctorPatientMapDemo {

    Connection con;
    ResultSet rsDoctor, rsPatient;
    Statement stmtDoctor, stmtPatient;
    HashMap<Integer, ArrayList<String>> doctorPatientMap = new HashMap<>();

    public DoctorPatientMapDemo() throws SQLException, ClassNotFoundException {
        con = MyConnection.getMysqConnection();
        stmtDoctor = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rsDoctor = stmtDoctor.executeQuery("SELECT * FROM doctor");

        stmtPatient = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rsPatient = stmtPatient.executeQuery("SELECT * FROM patient");
    }

    public void createMap() throws SQLException {
        int docid = 0;
        String doctorName = null;

        while (rsDoctor.next()) {
            docid = rsDoctor.getInt(1);
            doctorName = rsDoctor.getString(2);

            ArrayList<String> patientNames = new ArrayList<>();

            rsPatient.beforeFirst();
            while (rsPatient.next()) {
                if (rsPatient.getInt(3) == docid) {
                    patientNames.add(rsPatient.getString(2));
                }
            }

            
            System.out.println("Doctor ID: " + docid);
            System.out.println("Doctor Name: " + doctorName);
            System.out.println("Patients treated: " + patientNames);

            doctorPatientMap.put(docid, patientNames);
        }
        
        
       
    }


    public void show() {
        Set<Entry<Integer, ArrayList<String>>> set = doctorPatientMap.entrySet();
        Iterator<Entry<Integer, ArrayList<String>>> itr = set.iterator();

        while (itr.hasNext()) {
            Entry<Integer, ArrayList<String>> entry = itr.next();
            if (!entry.getValue().isEmpty()) {
                System.out.println("Doctor ID: " + entry.getKey());
                System.out.println("Patients treated: " + entry.getValue());
                
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DoctorPatientMapDemo obj = new DoctorPatientMapDemo();
       
        obj.createMap();
        obj.show();
    }
}
