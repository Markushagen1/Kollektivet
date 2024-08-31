package com.example.kollektivet.Controller;

import com.example.kollektivet.Exception.ResourceNotFoundException;
import com.example.kollektivet.Model.UserProfile;
import com.example.kollektivet.Repo.userProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private userProfileRepo userProfileRepo;

    // Make new profile
    @PostMapping
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileRepo.save(userProfile);
    }

    // Fetch existing by id
    @GetMapping("/{id}")
    public UserProfile getProfile(@PathVariable Long id) {
        return userProfileRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    // Update existing profile
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable Long id, @RequestBody UserProfile profileDetails) {
        UserProfile userProfile = userProfileRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        userProfile.setAge(profileDetails.getAge());
        userProfile.setName(profileDetails.getName());
        userProfile.setIntrests(profileDetails.getIntrests());
        userProfile.setBudget(profileDetails.getBudget());

        UserProfile updatedUserProfile = userProfileRepo.save(userProfile);
        return ResponseEntity.ok(updatedUserProfile);
    }

    // Delete a profile
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
        UserProfile userProfile = userProfileRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userProfileRepo.delete(userProfile);
        return ResponseEntity.ok().build();
    }
}

