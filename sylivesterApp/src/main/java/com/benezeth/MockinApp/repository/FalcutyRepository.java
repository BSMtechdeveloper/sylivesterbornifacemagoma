package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface FalcutyRepository extends JpaRepository<FacultyEntity,Long> {
    //All crud method for database
}
