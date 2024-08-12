package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Repository.JopPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JopPostService {
    private final JopPostRepository postRepository;

    public List<JobPost>getJopPost(){
        return postRepository.findAll();
    }


    public void addJopPost(JobPost jobPost){
        postRepository.save(jobPost);
    }


    public boolean updateJopPost(Integer id,JobPost jobPost){
        JobPost j = postRepository.findById(id).get();
        if(j==null){
            return false;
        }
        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setPostingDate(j.getPostingDate());
        j.setSalary(jobPost.getSalary());
       postRepository.save(j);
       return true;

    }



    public boolean deleteJopPost(Integer id){
        JobPost j = postRepository.findById(id).get();
        if(j==null){
            return false;
        }
        postRepository.delete(j);
        return true;
    }


}
