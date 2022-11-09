package com.findyourworker.findyourworker.controller;

import com.findyourworker.findyourworker.payload.JwtRequest;
import com.findyourworker.findyourworker.payload.JwtResponse;
import com.findyourworker.findyourworker.service.Impl.AdminServiceImpl;
import com.findyourworker.findyourworker.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String test(){
        return "Hello";
    }

    @PostMapping("/check")
    public String check(){
        return "Check pass";
    }

    @PostMapping("/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            System.out.println(jwtRequest.getUsername());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),
                    jwtRequest.getPassword()
            ));

        }
        catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials",e);

        }
        final UserDetails userDetails
                = adminService.loadUserByUsername(jwtRequest.getUsername());

        final String token=
                jwtUtil.generateToken(userDetails);
        System.out.println(token);
        return new JwtResponse(token);

    }

}
