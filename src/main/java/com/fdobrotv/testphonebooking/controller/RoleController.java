package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.RolesApi;
import com.fdobrotv.testphonebooking.dto.Role;
import com.fdobrotv.testphonebooking.dto.RoleIn;
import com.fdobrotv.testphonebooking.service.CRUDService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.test-phone-booking.base-path:/v1}")
public class RoleController implements RolesApi {

    private final CRUDService<Role, RoleIn> roleService;

    public RoleController(CRUDService<Role, RoleIn> roleService) {
        this.roleService = roleService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return RolesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteRoleById(UUID id) {
        roleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Role> createRole(RoleIn roleIn) {
        Role role = roleService.create(roleIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @Override
    public ResponseEntity<List<Role>> listRoles(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<Role> roles = roleService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }
}
