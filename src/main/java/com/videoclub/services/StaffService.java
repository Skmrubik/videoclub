package com.videoclub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoclub.entities.Staff;
import com.videoclub.repositories.StaffRepository;

@RestController
public class StaffService {
	
	@Autowired
	StaffRepository staffRepository;
	
	@GetMapping("/listStaffs")
	public ResponseEntity<List<Staff>> listStaffs() {
		try {
			List<Staff> listStaffs = new ArrayList<>();
			listStaffs = staffRepository.findAll();
			return new ResponseEntity<>(listStaffs, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
