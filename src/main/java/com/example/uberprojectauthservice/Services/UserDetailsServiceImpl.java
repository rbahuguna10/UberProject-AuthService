package com.example.uberprojectauthservice.Services;

import com.example.uberprojectauthservice.Helpers.AuthPassengerDetails;
import com.example.uberprojectauthservice.Models.Passenger;
import com.example.uberprojectauthservice.Repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

// This class is responsible for loading the user in the form of UserDetails object for auth.
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;


    @Override
    // Method Overloading doesn't care about variable name, so for simplicity we have 'email' in place of 'username'
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email); // email is the unique identifier
        if(passenger.isPresent()) {
            return new AuthPassengerDetails(passenger.get());
        }
        else {
            throw new UsernameNotFoundException("Cannot find the Passenger by the given Email");
        }
    }
}
