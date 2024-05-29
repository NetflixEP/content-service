package com.polytech.aps.viewvoyage.movie_service.public_interface.mapper;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.CastMember;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.CastMemberDto;

public class CastMemberMapper {
    public static CastMemberDto convertToCastMemberDto(CastMember castMember) {
        return CastMemberDto.builder()
                .id(castMember.getId())
                .roleName(castMember.getRoleName())
                .employeeFullName(castMember.getEmployeeFullName())
                .build();
    }

    private CastMemberMapper() {

    }
}
