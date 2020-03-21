package ssm.service;

import ssm.domain.Permission;
import ssm.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionsToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;
}
