package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.BasicUserDto;
import com.cooksys.groupfinal.dtos.ProfileDto;
import com.cooksys.groupfinal.dtos.TeamDto;
import com.cooksys.groupfinal.entities.Profile;
import com.cooksys.groupfinal.entities.Team;
import com.cooksys.groupfinal.entities.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T23:03:57-0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Override
    public TeamDto entityToDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setName( team.getName() );
        teamDto.setDescription( team.getDescription() );
        teamDto.setTeammates( basicUserMapper.entitiesToBasicUserDtos( team.getTeammates() ) );

        return teamDto;
    }

    @Override
    public Set<TeamDto> entitiesToDtos(Set<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        Set<TeamDto> set = new HashSet<TeamDto>( Math.max( (int) ( teams.size() / .75f ) + 1, 16 ) );
        for ( Team team : teams ) {
            set.add( entityToDto( team ) );
        }

        return set;
    }

    @Override
    public Team requestDtoToEntity(TeamDto team) {
        if ( team == null ) {
            return null;
        }

        Team team1 = new Team();

        team1.setId( team.getId() );
        team1.setName( team.getName() );
        team1.setDescription( team.getDescription() );
        team1.setTeammates( basicUserDtoSetToUserSet( team.getTeammates() ) );

        return team1;
    }

    protected Profile profileDtoToProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setFirstName( profileDto.getFirstName() );
        profile.setLastName( profileDto.getLastName() );
        profile.setEmail( profileDto.getEmail() );
        profile.setPhone( profileDto.getPhone() );

        return profile;
    }

    protected User basicUserDtoToUser(BasicUserDto basicUserDto) {
        if ( basicUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( basicUserDto.getId() );
        user.setProfile( profileDtoToProfile( basicUserDto.getProfile() ) );
        user.setActive( basicUserDto.isActive() );
        user.setAdmin( basicUserDto.isAdmin() );
        user.setStatus( basicUserDto.getStatus() );

        return user;
    }

    protected Set<User> basicUserDtoSetToUserSet(Set<BasicUserDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<User> set1 = new HashSet<User>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BasicUserDto basicUserDto : set ) {
            set1.add( basicUserDtoToUser( basicUserDto ) );
        }

        return set1;
    }
}
