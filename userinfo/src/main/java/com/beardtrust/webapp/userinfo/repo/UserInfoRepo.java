/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beardtrust.webapp.userinfo.repo;

import com.beardtrust.webapp.userinfo.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity, String> {
    
}
