package ssm.service;

import ssm.domain.Permission;

import java.util.List;


public interface PermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
