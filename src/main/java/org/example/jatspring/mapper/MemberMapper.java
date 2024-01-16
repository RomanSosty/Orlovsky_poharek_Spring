package org.example.jatspring.mapper;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.Member;

public class MemberMapper {

    public static Member memberToEntity(Member reqMember){
        Member member = new Member();
        member.setName(reqMember.getName());
        member.setDateOfBirth(reqMember.getDateOfBirth());
        member.setLastName(reqMember.getLastName());
        return member;
    }
}
