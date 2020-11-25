package com.spring.security.controllers;

import com.spring.security.DTOs.RegisterRequestDto;
import com.spring.security.configuration.JwtUtil;
import com.spring.security.models.AuthenticationRequest;
import com.spring.security.models.AuthenticationResponse;
import com.spring.security.models.Movie;
import com.spring.security.services.MovieServiceImpl;
import com.spring.security.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TestRestController {

    private final MovieServiceImpl movieService;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public TestRestController(MovieServiceImpl movieService, AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtTokenUtil) {
        this.movieService = movieService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("movies/{category}")
    public List<Movie> getAll(@PathVariable("category") String category,
                              @RequestParam("api_key") String apiKey,
                              @RequestParam("language") String language,
                              @RequestParam("page") int page) throws Exception {

        return movieService.getMoviesByCategory(category, apiKey, language, page);
    }

    @GetMapping("movie/{movie_id}")
    public Movie test(@PathVariable("movie_id") Integer movieId,
                      @RequestParam("api_key") String apiKey) throws IOException {

        return movieService.getMovieById(movieId, apiKey);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));

        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDto registerRequestDto) throws Exception{


    }
}
