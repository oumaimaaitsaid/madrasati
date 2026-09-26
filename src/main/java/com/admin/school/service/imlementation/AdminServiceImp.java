package com.admin.school.service.imlementation;

import com.admin.school.components.PasswordMaker;
import com.admin.school.dto.admine.Request;
import com.admin.school.dto.admine.Response;
import com.admin.school.entity.Admin;
import com.admin.school.exeception.UserAlreadyExistsException;
import com.admin.school.mappers.AdminMapper;
import com.admin.school.service.AdminService;
import com.admin.school.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AdminRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class AdminServiceImp implements AdminService {
    private AdminMapper mapper;
    private AdminRepository repository;
    private PasswordMaker passwordMaker;
    private EmailService mailSender;

    @Override
    public Response makeAdmin(Request request) {
        repository.findAdminByEmail(request.getEmail()).ifPresent(admin-> {
            throw new UserAlreadyExistsException("Admin with this email already exists");
        });
        Admin admin = mapper.toEntity(request);
        String password = passwordMaker.generateStrictPassword();
        admin.setPassword(password);
        mailSender.sendWelcomeEmail(request.getEmail(), request.getUsername(), password, "temp url to be changed later ", "temp holder to be changed later ");
        return mapper.toResponse(admin);
    }
}
