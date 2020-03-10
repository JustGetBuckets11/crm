package com.crm.service;

import com.crm.bean.Role;
import com.crm.bean.RoleExample;
import com.crm.enums.ExceptionEnums;
import com.crm.exception.CrmException;
import com.crm.mapper.RoleMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findAll(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    public Role findById(Long id) {
        if (id == null) {
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        return roleMapper.selectByPrimaryKey(id);
    }

    public void addRole(Role role) {
        if (role == null || StringUtils.isBlank(role.getRoleName())) {
            throw new CrmException(ExceptionEnums.PARAM_IS_NULL);
        }
        roleMapper.insert(role);
    }
}
