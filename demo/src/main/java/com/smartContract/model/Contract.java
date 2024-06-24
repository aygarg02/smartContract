package com.smartContract.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="contract")
public class Contract  {
    
    @Id
    private int id;
    private String name;
    private String SecondName;
    private String work;
    private String email;
    private boolean phone;
    private String image;
    private String descString;
    @ManyToOne(cascade = CascadeType.ALL)
    private Consumer consumer;
}
