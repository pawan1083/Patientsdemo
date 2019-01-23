package com.mytectra.patientspringboot.pawan.Patientsdemo.DAO.Impl;

import com.mytectra.patientspringboot.pawan.Patientsdemo.DAO.PatientDAO;
import com.mytectra.patientspringboot.pawan.Patientsdemo.model.Patient;
import com.mytectra.patientspringboot.pawan.Patientsdemo.model.PatientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertPatient(Patient patient) {
        String query = "INSERT INTO PATIENT(pid,pname,page) VALUES(?,?,?)";
        jdbcTemplate.update(query, patient.getPid(), patient.getPname(), patient.getPage());
    }

    public Patient getPatientById(int pid) {
        String query = "SELECT PNAME,PAGE FROM PATIENT WHERE PID=?";
        Patient patient = jdbcTemplate.queryForObject(query, new Object[]{pid}, new BeanPropertyRowMapper<>(Patient.class));
        return patient;
    }

    public List<Patient> getAllPatient() {
        String query = "SELECT pid, page, pname FROM PATIENT";
        RowMapper<Patient> rowMapper = new PatientRowMapper();
        return this.jdbcTemplate.query(query, rowMapper);
    }

    public void updatePatient(Patient patient) {
        String query = "UPDATE PATIENT SET pname=?,page=? WHERE pid=?";
        jdbcTemplate.update(query, patient.getPid(), patient.getPname(), patient.getPage());
    }

    public void deletePatient(int pid) {
        String query = "DELETE FROM PATIENT WHERE pid=?";
        jdbcTemplate.update(query, pid);
    }

}
