package com.briefs.hunters_league.service.Impl;


import com.briefs.hunters_league.domain.AppUser;
import com.briefs.hunters_league.repository.AppUserRepository;
import com.briefs.hunters_league.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }
}
