package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiRsponsee;
import com.example.job_seeking_system.Model.Application;
import com.example.job_seeking_system.Service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/application")
public class ApplicationController {

  private final ApplicationService applicationService;
  @GetMapping("/get")
  public ResponseEntity getAllApplications() {
    return  ResponseEntity.status(200).body(applicationService.getAllApplications());

  }
  @PostMapping("/add")
  public ResponseEntity addApplication(@RequestBody Application application, Errors errors) {
    if (errors.hasErrors()) {
      String message = errors.getFieldError().getDefaultMessage();
      return ResponseEntity.status(400).body(message);

    }
    if( applicationService.addApplication(application).equalsIgnoreCase("post Not Found ")){
      return ResponseEntity.status(400).body("post Not Found");
    }
    if ( applicationService.addApplication(application).equalsIgnoreCase("User Not Found")){
      return ResponseEntity.status(400).body("User Not Found");
    }
    applicationService.addApplication(application);
    return ResponseEntity.status(201).body(new ApiRsponsee("application added successfully"));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity updateApplication( @PathVariable Integer id,@RequestBody Application application, Errors errors) {
    if (errors.hasErrors()) {
      String message = errors.getFieldError().getDefaultMessage();
      return ResponseEntity.status(400).body(message);

    }

  boolean isUpdated = applicationService.updateApplication(id, application);
    if (isUpdated) {
      return ResponseEntity.status(201).body(new ApiRsponsee("application updated successfully"));
    }
    return ResponseEntity.status(404).body(new ApiRsponsee("application not found"));
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteApplication(@PathVariable Integer id) {
    boolean isDeleted = applicationService.deleteApplication(id);
    if (isDeleted) {
      return ResponseEntity.status(201).body(new ApiRsponsee("application deleted successfully"));
    }
    return ResponseEntity.status(404).body(new ApiRsponsee("application not found"));
  }

}
