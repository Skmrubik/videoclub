package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoclub.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
