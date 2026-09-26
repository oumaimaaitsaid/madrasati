package com.admin.school.mappers;

import com.admin.school.dto.admine.Request;
import com.admin.school.dto.admine.Response;
import com.admin.school.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(Request admin);
    Response toResponse(Admin admin);
}
