package com.rungroop.web.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClubDto {
    
    private Integer id ;
    @NotEmpty(message = "title not  should be empty !")
    @NotBlank(message = "title  should not be blanck")
    private String title;
    @NotEmpty(message = "photo not should be empty !")
    private String photoUrl ;
    @NotEmpty(message = "content not should be empty !")
    private String content ;
    private LocalDateTime  createdOn ;
    private LocalDateTime updatedOn;

    public ClubDto(){}

    public ClubDto(Integer id, String title, String photoUrl, String content, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.content = content;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
   

}
