package com.smartContract.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="consumer")
public class Consumer {
    
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumer_seq_gen")
    @SequenceGenerator(name = "consumer_seq_gen", sequenceName = "name_consumer", allocationSize = 1)
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private String ImageUrl;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Contract> contracts=new ArrayList<>();
    @Override
    public String toString() {
        return "Consumer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
                + role + ", enabled=" + enabled + ", ImageUrl=" + ImageUrl + "]";
    }
}
