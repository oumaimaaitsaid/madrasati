package com.admin.school.controller;

import com.admin.school.dto.admine.Request;
import com.admin.school.dto.admine.Response;
import com.admin.school.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping("add")
    public ResponseEntity<Response> addAdmin(@RequestBody Request request) {
        Response response = adminService.makeAdmin(request);
        return ResponseEntity.ok(response);
    }
}
