package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.FacultyEntity;
import com.benezeth.MockinApp.exception.FalcultyException;
import com.benezeth.MockinApp.repository.FalcutyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty_info")
@SuppressWarnings("ALL")
public class FalcutyController {
    @Autowired
    private FalcutyRepository falcutyRepository;
    //code for getting all user
    @GetMapping
    public List<FacultyEntity>getAllUser(){
        return falcutyRepository.findAll();
    }
    //code for creating user
    @PostMapping
    public FacultyEntity createUser(@RequestBody FacultyEntity facultyEntity){
        return falcutyRepository.save(facultyEntity);
    }
    @GetMapping("{id}")
    public ResponseEntity<FacultyEntity>getUserById(@PathVariable Long id){
        FacultyEntity getUser=falcutyRepository.findById(id).orElseThrow(()->new FalcultyException("user does not exit"));
  return ResponseEntity.ok(getUser);
    }
    //code for updating user
    @PutMapping("{id}")
    public ResponseEntity<FacultyEntity>UpdateUser(@PathVariable Long id,@RequestBody FacultyEntity UserDetails){
        FacultyEntity updateUser=falcutyRepository.findById(id).orElseThrow(()->new FalcultyException("user does not exist"));
        updateUser.setUserId(UserDetails.getUserId());
        updateUser.setUserName(UserDetails.getUserName());
        updateUser.setUserAddress(UserDetails.getUserJob());
        updateUser.setUserPhoneNo(UserDetails.getUserPhoneNo());
        updateUser.setUserAddress(UserDetails.getUserAddress());
    falcutyRepository.save(updateUser);
    return ResponseEntity.ok(updateUser);}
}
