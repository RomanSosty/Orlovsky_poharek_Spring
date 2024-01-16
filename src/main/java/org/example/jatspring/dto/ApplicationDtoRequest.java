package org.example.jatspring.dto;

import org.example.jatspring.entity.Member;

import java.util.List;

public record ApplicationDtoRequest(
        String groupName,
        String contact,
        String choreografiName,
        String ageCategory,
        String danceCategory,
        String nameOfChoreografer,
        int numOfDancer,
        String lenghtOfDance,
        int numOfDancerInGroup,
        String meansOfTransport,
        String message,
        List<Member> members
) { }
