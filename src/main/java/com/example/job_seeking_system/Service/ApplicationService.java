package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.Application;
import com.example.job_seeking_system.Repository.ApplicationRepository;
import com.example.job_seeking_system.Repository.JopPostRepository;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
private final UserRepository userRepository;
private final JopPostRepository postRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    public String addApplication(Application application) {
      if (postRepository.getById(application.getPostID())==null){
          return "Post Not Found";
      }
      if (userRepository.getById(application.getUserID())==null){
          return "User Not Found";
      }

        applicationRepository.save(application);
      return "Application Added";
    }
    public boolean updateApplication(Integer id,Application application) {
        Application a = applicationRepository.getById(id);
        if(a == null) {

            return false;

        }
       a.setPostID(application.getPostID());
        a.setPostID(application.getPostID());
        applicationRepository.save(a);
        return true;

    }
    public boolean deleteApplication(Integer id) {
        Application a = applicationRepository.getById(id);
        if(a == null) {
            return false;

        }
        applicationRepository.delete(a);
        return true;

    }
}
