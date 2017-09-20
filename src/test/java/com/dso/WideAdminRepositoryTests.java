package com.dso;

import com.dso.domain.WideAdmin;
import com.dso.domain.WideRole;
import com.dso.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
@Log
public class WideAdminRepositoryTests {
    @Autowired
    WideAdminRepository wideAdminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Transactional
    @Test
    public void testInsertMA() {
        WideAdmin wideAdmin = new WideAdmin();
        wideAdmin.setWideAdminEmail("ma@email.com");
        wideAdmin.setWideAdminName("master");
        wideAdmin.setWideAdminPassword(passwordEncoder.encode("1234"));
        wideAdmin.setWideAdminContractFinishDate(new Date());
        wideAdmin.setWideAdminContractStatusCode("CY");

        WideRole wideRole = new WideRole();
        wideRole.setWideRoleCode("MA");

        wideAdmin.setWideAdminRoleCode(Arrays.asList(wideRole));

        wideAdminRepository.save(wideAdmin);
    }
}
