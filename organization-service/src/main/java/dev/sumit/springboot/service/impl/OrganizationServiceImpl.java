package dev.sumit.springboot.service.impl;

import lombok.AllArgsConstructor;
import dev.sumit.springboot.dto.OrganizationDto;
import dev.sumit.springboot.entity.Organization;
import dev.sumit.springboot.mapper.OrganizationMapper;
import dev.sumit.springboot.repository.OrganizationRepository;
import dev.sumit.springboot.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
