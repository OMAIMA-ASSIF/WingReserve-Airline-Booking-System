package net.omaima.patientservice.service;

import lombok.AllArgsConstructor;
import net.omaima.patientservice.dto.PatientRequestDTO;
import net.omaima.patientservice.dto.PatientResponseDTO;
import net.omaima.patientservice.mapper.PatientMapper;
import net.omaima.patientservice.model.Patient;
import net.omaima.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

}
