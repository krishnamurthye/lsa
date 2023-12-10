package com.ls.controller;


import com.ls.config.PortalRole;
import com.ls.domain.Admin;
import com.ls.domain.Person;
import com.ls.domain.UserRole;
import com.ls.repository.AdminRepository;
import com.ls.service.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Random;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthUser authUser;

    @Autowired
    private AdminRepository adminRepository;

    @RolesAllowed({PortalRole.Types.SUPER_ADMIN})
    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin) throws Exception {

        if (admin != null) {
            UserDetails userDetails = authUser.getUserDetails();
            Random random = new Random();
            Person person = admin.getUser();
            admin.getUser().setId((person.getFirstName() + person.getLastName() + person.getEmailId()) + random.nextInt(1000));
            return adminRepository.save(admin);

        }
        throw new Exception("Invalid Input");
    }


}
