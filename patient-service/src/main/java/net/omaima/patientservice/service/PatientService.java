package net.omaima.patientservice.service;

import lombok.AllArgsConstructor;
import net.omaima.patientservice.dto.PatientResponseDTO;
import net.omaima.patientservice.mapper.PatientMapper;
import net.omaima.patientservice.model.Patient;
import net.omaima.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient-> PatientMapper.toDTO(patient)).toList();

        return patientResponseDTOs;
    }

}
