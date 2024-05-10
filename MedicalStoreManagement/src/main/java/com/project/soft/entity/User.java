package com.project.soft.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(length =20, nullable=false, unique=true)
	@NotBlank(message="UserName cannot be blank!!")
    private  String userName;
    
    @Column(nullable=false)
	@NotBlank(message="User Password cannot be blank!!")
    private String password;
    
    @Column(length =25, nullable=false)
	@NotBlank(message="User first Name cannot be blank!!")
    private String firstName;
    
    
    @Column(length =25, nullable=false)
	@NotBlank(message="User last Name cannot be blank!!")
    private String lastName;
    
    @Column(length =20, nullable=false, unique=true)
	@NotBlank(message="User Email cannot be blank!!")
	@Email(message="Email id is not proper!!")
    private String email;
    
    @Column(length =20, nullable=false, unique=true)
	@NotBlank(message="Phone number cannot be null!!")
    private String phone;
    
    
    private  boolean enable=true;

    private String profile;
    
    
   // @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
   //@JsonIgnore
    //Set<UserRole> userRoles=new HashSet<>();
    


}
