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


//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody AdminDTO adminDTO) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(adminDTO.getUserName(), adminDTO.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtil.generateToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }
//    @PostMapping("/authenticate")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
//
//        }
//        catch (Exception e){
//            throw new Exception("Invalid user name or password");
//        }
//    return jwtUtil.generateToken(authRequest.getUserName());
//
//    }

}
