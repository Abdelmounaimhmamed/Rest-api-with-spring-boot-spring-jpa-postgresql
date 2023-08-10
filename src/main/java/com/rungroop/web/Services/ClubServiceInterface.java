package com.rungroop.web.Services;


import java.util.List;


import com.rungroop.web.Dto.ClubDto;


public interface ClubServiceInterface  {

    List<ClubDto> findAllClub();
    ClubDto saveClub(ClubDto club);
    ClubDto findOneClub(Integer id);
    ClubDto updateOldClub(Integer id , ClubDto newClub);
    public String deleteClub(Integer id);
    List<ClubDto> searchClubs(String query);
    
}
