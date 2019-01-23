package com.mytectra.patientspringboot.pawan.Patientsdemo.Controller;

import com.mytectra.patientspringboot.pawan.Patientsdemo.Service.PatientService;
import com.mytectra.patientspringboot.pawan.Patientsdemo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.List;

//@RestController("/patient")
@Controller
@RequestMapping("patient")
public class PatientRestEndPoint {
    @Autowired
    PatientService patientService;
    @PostMapping("insertpatient")
    public ResponseEntity<Void> insertPatient(@RequestBody Patient patient , UriComponentsBuilder builder) {
         patientService.insertPatient(patient);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/patient/{id}").buildAndExpand(patient.getPid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping("getallpatients")
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> list = patientService.getAllPatient();
        return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
    }
    @GetMapping("getbyidpatient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id) {
        Patient patient = patientService.getPatientById(id);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
    @PutMapping("updatepatient")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
    @DeleteMapping("deletepatient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Integer id) {
        patientService.deletePatient(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}




