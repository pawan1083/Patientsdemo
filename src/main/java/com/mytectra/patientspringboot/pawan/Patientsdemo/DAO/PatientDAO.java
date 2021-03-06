package com.mytectra.patientspringboot.pawan.Patientsdemo.DAO;

import com.mytectra.patientspringboot.pawan.Patientsdemo.model.Patient;

import java.util.List;

public interface PatientDAO {
    void insertPatient(Patient patient);

    Patient getPatientById(int pid);

    List<Patient> getAllPatient();

    void updatePatient(Patient patient);

    void deletePatient(int pid);

}
