package org.example.jatspring.mapper;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.DanceGroup;

public class DanceGroupMapper {

    public static DanceGroup danceGroupToEtity(ApplicationDtoRequest request){
        DanceGroup danceGroup = new DanceGroup();
        danceGroup.setName(request.groupName());
        danceGroup.setNumOfDancer(request.numOfDancerInGroup());
        return danceGroup;
    }
}
