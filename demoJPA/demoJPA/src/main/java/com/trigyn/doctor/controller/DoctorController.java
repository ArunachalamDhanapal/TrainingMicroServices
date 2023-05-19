package com.trigyn.doctor.controller;

import com.trigyn.doctor.model.DoctorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorServiceService;
    @GetMapping("/doctor")
    List<DoctorVO> getDoctor(@RequestParam (required = false) String name) {
        if (name != null)
            return doctorService.findDoctorByName(name);
        else
            return doctorService.getAll();
    }

    @GetMapping("/getdoctorbyname")
    List<DoctorVO> getDoctorByName(@RequestParam (required = false) String name) {
        if (name != null)
            return doctorService.getDoctorByName(name);
        else
            return doctorService.getAll();
    }


    @PostMapping("/doctor")
    Boolean createSoctor(@RequestBody DoctorVO doctorVO){
        return doctorService.createDoctor(doctorVO);
    }
}