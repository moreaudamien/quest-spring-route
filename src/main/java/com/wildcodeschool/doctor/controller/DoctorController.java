package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {

        Doctor doctor = new Doctor();

        if (number == 13) {
            doctor.setName("Jodie Whittaker");
            doctor.setNumber(13);
            return doctor;
        } else if (number > 0 && number < 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404");
        }

    }
}