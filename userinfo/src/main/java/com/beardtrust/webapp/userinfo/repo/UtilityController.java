/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beardtrust.webapp.userinfo.repo;

import com.beardtrust.webapp.userinfo.entity.UserInfoEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@RequestMapping("/beardtrust/utility")
@RestController
public class UtilityController {
    String[] fnames = {"Joe", "Nathan", "Matthew", "Davis", "Charles", "Debra", "Naomi", "Noreen", "Nathalie", "Sean"};
    String[] lnames = {"Howland", "Grier", "Crowell", "Hill", "Oliner", "Boyd", "Smith", "Doe", "Ayres", "Grier"};
    String[] user_id = {"jhkgvdt", "lkjgliu", "Matthew", "Davis", "Charles", "Debra", "Naomi", "Noreen", "Nathalie", "Sean"};
    String[] username = {"JoeChevy", "NCGBSNS", "M.Crow", "DaHill123", "Dimadome", "Debreesh", "Omio", "N'Rang", "Sestra", "DaGreesh"};
    String[] password = {"Cars567", "JavaJob15", "1234567", "MyPass61", "DimmyDo98", "NathanPass", "oo00oo", "TellNobody", "hush", "rootpass"};
    String[] email = {"Joe@Chevy.com", "NG@SS.com", "MC@SS.com", "DH@SS.com", "CO@SS.com", "DB@gmail.com", "NS@fake.com", "ND@hotmail.com", "NA@me.com", "SG@icloud.com"};
    String[] phone = {"3306158297", "3303046134", "6155565184", "6304453980", "8456128791", "3303211487", "8126555323", "6308772786", "3303045925", "3303211915"};
    String[] dob = {"1963-05-17", "1997-09-05", "1983-06-12", "1995-08-13", "1997-11-16", "1975-04-15", "2002-02-03", "2003-05-17", "2000-03-22", "1973-03-12"};
    String[] type = {"USER", "ADMN", "ADMN", "ADMN", "ADMN", "USER", "USER", "USER", "USER", "USER"};
    private UserInfoRepo repo;
        
        @Autowired
    public UtilityController(UserInfoRepo repo) {
        this.repo = repo;
    }
    
    @GetMapping("/generate")
    public String generateUser() {
        
        for (int i = 0; i < 10; i++) {
            UserInfoEntity us = new UserInfoEntity();
            us.setDateOfBirth(LocalDate.parse(dob[i]));
            us.setFirstName(fnames[i]);
            us.setLastName(lnames[i]);
            us.setUsername(username[i]);
            us.setPassword(password[i]);
            us.setUserId(user_id[i]);
            us.setRole(type[i]);
            us.setPhone(phone[i]);
            repo.save(us);
        }
        return "Users Added";
    }
    @GetMapping("/read")
    public List<UserInfoEntity> getUsers() {
        return repo.findAll();
    }
    
    @GetMapping("/test")
    public String test() {
        return "test passed";
    }
    
}
