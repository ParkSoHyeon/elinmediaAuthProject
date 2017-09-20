package com.dso;

import com.dso.domain.Advertiser;
import com.dso.domain.WideAdmin;
import com.dso.persistence.AdvertiserRepository;
import com.dso.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log
@Commit
public class AdvertiserTests {
    @Autowired
    private WideAdminRepository wideAdminRepository;

    @Autowired
    private AdvertiserRepository advertiserRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    @WithMockUser(username = "ma@email.com", password = "1234")
    public void testAdvertiser() throws Exception {

        mockMvc.perform(post("/admin/advertiser/register")
                .param("advertiserEmail", "abc@naver.com")
                .param("advertiserName", "광고주")
                .param("advertiserContractStatusCode", "CY")
                .param("advertiserContractFinishDate", new SimpleDateFormat("yyyy-mm-dd").format(new Date(2019,11,20))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "ma@email.com", password = "1234")
    public void testLoginSuccess() throws Exception {
        mockMvc.perform(get("/admin/main"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
