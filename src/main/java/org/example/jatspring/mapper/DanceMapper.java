package org.example.jatspring.mapper;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.Dance;
import org.example.jatspring.entity.Member;

import java.util.Set;

public class DanceMapper {

    public static Dance danceToEntity(ApplicationDtoRequest request, Set<Member> memberList){
        Dance dance = new Dance();
        dance.setCategory(request.danceCategory());
        dance.setChoreographer(request.nameOfChoreografer());
        dance.setName(request.choreografiName());
        dance.setLenght(request.lenghtOfDance());
        dance.setNumOfDancer(request.numOfDancer());
        dance.setMembers(memberList);
        return dance;
    }
}
