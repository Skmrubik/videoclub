package com.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.videoclub.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	@Query(value = "select * From Staff s where staff_id = ?1", nativeQuery = true)
	Staff getStaffById(Integer staffId);

}
