package com.spotify66_times.services;

import com.spotify66_times.entity.Library;
import com.spotify66_times.entity.Playlist;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spotify66_times.dtos.LoginUserDto;
import com.spotify66_times.dtos.RegisterUserDto;
import com.spotify66_times.entity.User;
import com.spotify66_times.repo.UserRepository;

import java.util.ArrayList;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        Library xyz3 = new Library();
        user.setLibrary(xyz3);
        Playlist xy3 = new Playlist();
        xyz3.setSongs(new ArrayList<>());
        user.setPlaylist(xy3);
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
    public void logout() {
        userRepository.deleteAll();


    }

}

