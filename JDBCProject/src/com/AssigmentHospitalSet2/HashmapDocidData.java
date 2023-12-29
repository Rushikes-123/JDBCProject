package com.AssigmentHospitalSet2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Iterator;

public class HashmapDocidData {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Map<Integer, List<Paitent>> map = new HashMap<>();

    public void hashmapDocidData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to the database...");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcoursedb", "root", "root");
        sql = "SELECT * FROM patients";
        pst = con.prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
            int docid = rs.getInt("docid");
            int pid = rs.getInt("pid");
            String pname = rs.getString("pname");
            int age = rs.getInt("age");
            float weight = rs.getFloat("weight");
            String email = rs.getString("email");
            Date admissiondate=rs.getDate("admissiondate");

            Paitent patient = new Paitent(pid, pname, age, weight, email,admissiondate, docid);

            if (map.containsKey(docid)) {
                map.get(docid).add(patient);
            } else {
                List<Paitent> patients = new ArrayList<>();
                patients.add(patient);
                map.put(docid, patients);
            }
        }
    }

    public void showdata() {
        Set<Entry<Integer, List<Paitent>>> set = map.entrySet();
        Iterator<Entry<Integer, List<Paitent>>> itr = set.iterator();
        while (itr.hasNext()) {
            Entry<Integer, List<Paitent>> entry = itr.next();
            int docid = entry.getKey();
            List<Paitent> patients = entry.getValue();

            System.out.println("DocID: " + docid);
            for (Paitent patient : patients) {
                System.out.println(patient);
            }
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        HashmapDocidData hd = new HashmapDocidData();
        hd.hashmapDocidData();
        hd.showdata();
    }
}
