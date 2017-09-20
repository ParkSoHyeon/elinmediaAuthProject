package com.dso.controller;

import com.dso.domain.Advertiser;
import com.dso.domain.WideAdmin;
import com.dso.domain.WideRole;
import com.dso.persistence.AdvertiserRepository;
import com.dso.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/admin/advertiser/")
@Log
public class AdvertiserController {
    @Autowired
    private WideAdminRepository wideAdminRepository;

    @Autowired
    private AdvertiserRepository advertiserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public void getRegister() {
        log.info("등록 페이지");
    }

    @PostMapping("/register")
    public void postRegister(Advertiser advertiser) {
        if(!wideAdminRepository.findById(advertiser.getAdvertiserEmail()).isPresent()) {
            advertiserRepository.save(advertiser);

            WideAdmin wideAdmin = new WideAdmin();
            wideAdmin.setWideAdminEmail(advertiser.getAdvertiserEmail());
            wideAdmin.setWideAdminPassword(passwordEncoder.encode("1234"));
            wideAdmin.setWideAdminName(advertiser.getAdvertiserName());
            wideAdmin.setWideAdminContractStatusCode(advertiser.getAdvertiserContractStatusCode());
            wideAdmin.setWideAdminContractFinishDate(advertiser.getAdvertiserContractFinishDate());
            WideRole wideRole = new WideRole();
            wideRole.setWideRoleCode("AD");
            wideAdmin.setWideAdminRoleCode(Arrays.asList(wideRole));

            wideAdminRepository.save(wideAdmin);

            log.info("커밋 테스트");
        }

    }

}
