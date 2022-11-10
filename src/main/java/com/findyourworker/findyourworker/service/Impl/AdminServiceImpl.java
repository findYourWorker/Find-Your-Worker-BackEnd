package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.AdminDTO;
import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Admin;
import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.repository.AdminRepository;
import com.findyourworker.findyourworker.repository.LabourerRepository;
import com.findyourworker.findyourworker.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements UserDetailsService,AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LabourerRepository labourerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Admin admin=adminRepository.findAdminByUsername(userName);
//        System.out.println("HEllo"+admin);
        System.out.println(admin);
        return new User(admin.getUsername(),admin.getPassword(),new ArrayList<>());

//        return new User(admin.getUsername(),admin.getPassword(),new ArrayList<>());
    }
    @Override
    public void saveAdmin(AdminDTO adminDTO){
//        System.out.println(adminDTO);
        String encodedPassword= passwordEncoder.encode(adminDTO.getPassword());
//        System.out.println(encodedPassword);
        adminDTO.setPassword(encodedPassword);
//        System.out.println(adminDTO.getPassword());
        Admin admin = modelMapper.map(adminDTO, Admin.class);
//        System.out.println(admin.getUsername());
        adminRepository.save(admin);

    }
    @Override
    public void changeActivation(String labourerId){
        Long id=Long.parseLong(labourerId);
        System.out.println(id);

        Labourer labourer= labourerRepository.findByLabourerId(id).get();
//        labourerRepository.deleteByLabourerId(id);
        Integer activation=Integer.parseInt(labourer.getActive());

        if(activation==1){
            labourer.setActive("0");
        } else if (activation==0) {
            System.out.println("caught");
            labourer.setActive("1");

        }
        labourerRepository.save(labourer);
        System.out.println(labourer);
    }
}
