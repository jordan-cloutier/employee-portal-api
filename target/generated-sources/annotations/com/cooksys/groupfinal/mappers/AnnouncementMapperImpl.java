package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.AnnouncementDto;
import com.cooksys.groupfinal.entities.Announcement;
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
public class AnnouncementMapperImpl implements AnnouncementMapper {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Override
    public AnnouncementDto entityToDto(Announcement announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setId( announcement.getId() );
        announcementDto.setDate( announcement.getDate() );
        announcementDto.setTitle( announcement.getTitle() );
        announcementDto.setMessage( announcement.getMessage() );
        announcementDto.setAuthor( basicUserMapper.entityToBasicUserDto( announcement.getAuthor() ) );

        return announcementDto;
    }

    @Override
    public Set<AnnouncementDto> entitiesToDtos(Set<Announcement> announcement) {
        if ( announcement == null ) {
            return null;
        }

        Set<AnnouncementDto> set = new HashSet<AnnouncementDto>( Math.max( (int) ( announcement.size() / .75f ) + 1, 16 ) );
        for ( Announcement announcement1 : announcement ) {
            set.add( entityToDto( announcement1 ) );
        }

        return set;
    }
}
