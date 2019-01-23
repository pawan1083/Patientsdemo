package com.mytectra.patientspringboot.pawan.Patientsdemo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRowMapper implements RowMapper<Patient> {

    public Patient mapRow(ResultSet row, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setPid(row.getInt("pid"));
        patient.setPname(row.getString("pname"));
        patient.setPage(row.getInt("page"));

        return patient;
    }

}
