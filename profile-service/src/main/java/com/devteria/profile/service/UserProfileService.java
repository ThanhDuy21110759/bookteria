package com.devteria.profile.service;

import org.springframework.stereotype.Service;

import com.devteria.profile.dto.request.ProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileReponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.Mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public List<UserProfileReponse> getAllProfiles() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        return userProfiles.stream().map(userProfileMapper::toUserProfileReponse).toList();
    }

    public UserProfileReponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileReponse(userProfile);
    }

    public UserProfileReponse getProfile(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return userProfileMapper.toUserProfileReponse(userProfile);
    }
}
