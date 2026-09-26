package com.admin.school.service;

import com.admin.school.dto.admine.Request;
import com.admin.school.dto.admine.Response;
import org.springframework.stereotype.Service;

public interface AdminService {
    Response makeAdmin(Request request);
}
