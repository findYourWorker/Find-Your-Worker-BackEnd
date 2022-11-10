package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.AdminDTO;
import com.findyourworker.findyourworker.dto.LabourerDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);

    void changeActivation(String labourerId);

}

