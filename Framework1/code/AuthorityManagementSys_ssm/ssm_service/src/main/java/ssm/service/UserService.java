package ssm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ssm.domain.Role;
import ssm.domain.UserInfo;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRolesToUser(String userId, String[] roleIds) throws Exception;
}
