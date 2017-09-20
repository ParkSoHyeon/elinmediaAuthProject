package com.dso.security;

import com.dso.domain.WideSession;
import com.dso.persistence.WideSessionRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    WideSessionRepository wideSessionRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);
        log.info("로그인 성공 핸들러, ");
        String SID = request.getSession().getId();

        if(!(wideSessionRepository.findById(SID).isPresent())){
            WideSession wideSession = new WideSession();
            wideSession.setWideAdminEmail(authentication.getName());
            wideSession.setWideSessionId(SID);
            wideSession.setWideAdminName("");
            wideSession.setWideAdminRole(authentication.getAuthorities().toString().substring(1,8));
            wideSession.setWideLoginStatus(1);

            wideSessionRepository.save(wideSession);
        }

    }
}
