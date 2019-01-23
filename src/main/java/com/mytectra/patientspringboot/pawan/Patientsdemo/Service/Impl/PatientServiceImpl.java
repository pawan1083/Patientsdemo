package com.mytectra.patientspringboot.pawan.Patientsdemo.Service.Impl;

import com.mytectra.patientspringboot.pawan.Patientsdemo.DAO.PatientDAO;
import com.mytectra.patientspringboot.pawan.Patientsdemo.Service.PatientService;
import com.mytectra.patientspringboot.pawan.Patientsdemo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public void insertPatient(Patient patient) {
        patientDAO.insertPatient(patient);
    }

    @Override
    public Patient getPatientById(int pid) {
        Patient obj = patientDAO.getPatientById(pid);
        return obj;
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientDAO.getAllPatient();
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(int pid) {
        patientDAO.deletePatient(pid);
    }
}

