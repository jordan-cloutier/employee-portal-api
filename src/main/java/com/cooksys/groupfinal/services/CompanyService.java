package com.cooksys.groupfinal.services;

import java.util.Set;


import com.cooksys.groupfinal.dtos.*;
import com.cooksys.groupfinal.repositories.AnnouncementRepository;
import com.cooksys.groupfinal.dtos.AnnouncementDto;
import com.cooksys.groupfinal.dtos.FullUserDto;
import com.cooksys.groupfinal.dtos.ProjectDto;
import com.cooksys.groupfinal.dtos.TeamDto;
import com.cooksys.groupfinal.entities.Company;


public interface CompanyService {

	Set<FullUserDto> getAllUsers(Long id);

	Set<AnnouncementDto> getAllAnnouncements(Long id);

	Set<TeamDto> getAllTeams(Long id);

	Set<ProjectDto> getAllProjects(Long companyId, Long teamId);


	AnnouncementDto createAnnouncement(Long id, AnnouncementRequestDto announcementRequestDto);
	Set<Company>  getAllCompanies();

	ProjectDto updateProject(Long companyId, Long teamId, Long projectId, ProjectDto projectDto);
	ProjectDto createProject(Long companyId, Long teamId, ProjectDto projectDto);

}
