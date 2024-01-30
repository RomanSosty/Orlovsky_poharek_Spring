package org.example.jatspring.service;

import org.example.jatspring.dto.ApplicationDtoRequest;
import org.example.jatspring.entity.ApplicationForm;
import org.example.jatspring.entity.Dance;
import org.example.jatspring.entity.DanceGroup;
import org.example.jatspring.entity.Member;
import org.example.jatspring.mapper.ApplicationFormMapper;
import org.example.jatspring.mapper.DanceGroupMapper;
import org.example.jatspring.mapper.DanceMapper;
import org.example.jatspring.mapper.MemberMapper;
import org.example.jatspring.repository.ApplicationFormRepository;
import org.example.jatspring.repository.DanceGroupRepository;
import org.example.jatspring.repository.DanceRepository;
import org.example.jatspring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationFormRepository applicationFormRepository;
    private final DanceRepository danceRepository;
    private final DanceGroupRepository danceGroupRepository;
    private final MemberRepository memberRepository;

    public ApplicationServiceImpl(ApplicationFormRepository applicationFormRepository, DanceRepository danceRepository, DanceGroupRepository danceGroupRepository, MemberRepository memberRepository) {
        this.applicationFormRepository = applicationFormRepository;
        this.danceRepository = danceRepository;
        this.danceGroupRepository = danceGroupRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public ApplicationForm createApplicationForm(ApplicationDtoRequest request) {

        Set<Member> members = new HashSet<>();

        request.members().stream().toList().forEach(reqMember -> {
            Member member = MemberMapper.memberToEntity(reqMember);
            memberRepository.save(member);
            members.add(member);
        });

        DanceGroup danceGroup;
        List<DanceGroup> danceGroups = danceGroupRepository.duplicityDanceGroup(request.groupName());

        if(danceGroups.isEmpty()){
            danceGroup = DanceGroupMapper.danceGroupToEtity(request);
            danceGroupRepository.save(danceGroup);
        }else{
            danceGroup = danceGroups.get(0);
        }

        Dance dance = DanceMapper.danceToEntity(request, members);
        danceRepository.save(dance);

        ApplicationForm applicationForm = ApplicationFormMapper.applicationFormToEntity(request, dance, danceGroup);
        applicationFormRepository.save(applicationForm);

        return applicationForm;
    }

    @Override
    public List<ApplicationForm> getAllForms() {
        return applicationFormRepository.findAll();
    }
}
