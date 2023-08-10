package com.rungroop.web.Models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Event")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type ;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;


    @ManyToOne
    @JoinColumn(name = "clubId" , nullable = false)
    private Club club ;
}


