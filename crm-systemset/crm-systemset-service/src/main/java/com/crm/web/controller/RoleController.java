package com.crm.web.controller;

import com.crm.bean.Role;
import com.crm.bean.RoleExample;
import com.crm.exception.CrmException;
import com.crm.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "角色管理", tags = {"角色管理"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/getAll")
    public List<Role> getAll(RoleExample example) {
        return roleService.findAll(example);
    }

    @PostMapping("/add")
    public void addRole(Role role) {
        roleService.addRole(role);
    }

    @GetMapping("/selectById")
    @ApiOperation("根据id查询角色")
    public ResponseEntity selectById(Long id) {
        try {
            Role role = roleService.findById(id);
            return ResponseEntity.ok(role);
        } catch (CrmException e) {
            e.printStackTrace();
            return ResponseEntity.status(e.getExceptionEnums().getCode()).body(e.getExceptionEnums().getMsg());
        }
    }
}
