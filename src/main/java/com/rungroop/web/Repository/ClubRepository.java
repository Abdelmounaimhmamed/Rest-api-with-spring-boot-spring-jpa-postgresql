package com.rungroop.web.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rungroop.web.Models.Club;

public interface ClubRepository  extends JpaRepository<Club,Integer>{
        Optional<Club> findByTitle(String title);
        @Query("select c from Club c  where c.title like concat ('%' , :query ,'%')")
        List<Club> searchClubs(String query);
}
