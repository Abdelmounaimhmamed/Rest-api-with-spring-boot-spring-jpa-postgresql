package com.rungroop.web.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rungroop.web.Dto.ClubDto;
import com.rungroop.web.Services.ClubService;

@RestController
@RequestMapping("clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;
    
    @GetMapping("/all")
    public List<ClubDto> getAllClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClub();
        model.addAttribute("clubs", clubs);
        return this.clubService.findAllClub();
    }


    @PostMapping("/new")
    public ClubDto createNewClub(@Valid @RequestBody ClubDto club){
        return this.clubService.saveClub(club);
    }
    
    @GetMapping("/{id}")
    public ClubDto findOneClub(@PathVariable("id") Integer id){
        return this.clubService.findOneClub(id);
    }

    @PostMapping("/{id}/edit")
    public ClubDto updateOldClub(@PathVariable("id") Integer id ,@Valid @RequestBody ClubDto newClub){
        return this.clubService.updateOldClub(id , newClub);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deleteClub(@PathVariable("id") Integer id){
        return new ResponseEntity<String>(this.clubService.deleteClub(id),HttpStatus.OK);
    }


    @GetMapping("/search")
    public List<ClubDto> searchedClubs(@RequestParam(value = "query") String query){
        return this.clubService.searchClubs(query);
    }

}
