package com.example.job_seeking_system.Controller;

import com.example.job_seeking_system.ApiResponse.ApiRsponsee;
import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Service.JopPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/job")
public class JopPostController {
    private final JopPostService jopPostService;

    @GetMapping("/get")
    public ResponseEntity getJopPost(){
        return ResponseEntity.status(200).body(jopPostService.getJopPost());
    }

    @PostMapping("/add")
    public ResponseEntity addJopPost(@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        jopPostService.addJopPost(jobPost);
        return ResponseEntity.status(200).body(new ApiRsponsee("Successfully added post"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJopPost(@PathVariable Integer id,@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jopPostService.updateJopPost(id, jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiRsponsee("Successfully updated post"));
        }
        return ResponseEntity.status(400).body(new ApiRsponsee("Failed to update post"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJopPost(@PathVariable Integer id){
        boolean isDeleted = jopPostService.deleteJopPost(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiRsponsee("Successfully deleted post"));
        }
        return ResponseEntity.status(400).body(new ApiRsponsee("Failed to delete post"));
    }

}
