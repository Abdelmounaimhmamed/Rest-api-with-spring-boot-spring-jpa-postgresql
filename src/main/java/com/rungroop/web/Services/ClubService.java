package com.rungroop.web.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rungroop.web.Dto.ClubDto;
import com.rungroop.web.Models.Club;
import com.rungroop.web.Repository.ClubRepository;


@Service
public class ClubService  implements ClubServiceInterface {

    @Autowired
    private ClubRepository clubRepo;

    @Autowired
    private ModelMapper modelMapper;


    public ClubDto convertEntityToDto(Club club){
        ClubDto clubDto = new ClubDto();
        clubDto = modelMapper.map(club , ClubDto.class);
        return clubDto;
    }

    public Club convertDtoToEntity(ClubDto clubDto){
        Club club = new Club();
        club = modelMapper.map(clubDto , Club.class);
        return club;
    }
  
    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs  = this.clubRepo.findAll();
        return clubs.stream().map((club) -> convertEntityToDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findOneClub(Integer id){
        Club club = this.clubRepo.findById(id).get();
        if(club == null){
            return null;
        }
        return this.convertEntityToDto(club);
    }
    
    @Override
    public ClubDto saveClub(ClubDto club){
        Club newClub =  this.clubRepo.save(convertDtoToEntity(club));
        return this.convertEntityToDto(newClub);
    }

    @Override
    public String deleteClub(Integer id){
        ClubDto FoundedClub = this.findOneClub(id);
        if(FoundedClub != null){
            this.clubRepo.deleteById(id);
            return "deleted !";
        }
        return "no club with this id";
    }



    @Override
    public ClubDto updateOldClub(Integer id ,ClubDto newClub){
        ClubDto club =  this.findOneClub(id);
        club.setTitle(newClub.getTitle() != null ? newClub.getTitle() : club.getTitle());
        club.setContent(newClub.getContent() != null ? newClub.getContent() : club.getContent());
        club.setPhotoUrl(newClub.getPhotoUrl() != null ? newClub.getPhotoUrl() : club.getPhotoUrl());        
        club.setCreatedOn(newClub.getCreatedOn() != null ? newClub.getCreatedOn() : club.getCreatedOn());        
        club.setUpdatedOn(newClub.getUpdatedOn() != null ? newClub.getUpdatedOn() : club.getUpdatedOn());
        Club updatedClub = this.clubRepo.save(convertDtoToEntity(club));
        return convertEntityToDto(updatedClub);
    }
    

    @Override
    public List<ClubDto> searchClubs(String query){
        List<Club> clubs  = this.clubRepo.searchClubs(query);
        return clubs.stream().map( (club) -> convertEntityToDto(club)).collect(Collectors.toList());
    }

   

 
       
    
}
