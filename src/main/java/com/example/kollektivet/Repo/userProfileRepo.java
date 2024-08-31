package com.example.kollektivet.Repo;

import com.example.kollektivet.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userProfileRepo extends JpaRepository<UserProfile, Long> {
}
