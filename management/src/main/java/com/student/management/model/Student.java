package com.student.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "student")
public class Student {
	
	 
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="dateOfAdmission")
    private String dateOfAdmission;
    
    @Column(name="physics")
    private float physics;
    
    @Column(name="chemistry")
    private float chemistry;
    
    @Column(name="biology")
    private float biology;
 
    public Student() {
    }
 
    
    public Student(Integer id, String name, String dateOfAdmission, float physics, float chemistry, float biology) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfAdmission = dateOfAdmission;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
	}
   


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDateOfAdmission() {
		return dateOfAdmission;
	}


	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}


	public float getPhysics() {
		return physics;
	}


	public void setPhysics(float physics) {
		this.physics = physics;
	}


	public float getChemistry() {
		return chemistry;
	}


	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}


	public float getBiology() {
		return biology;
	}


	public void setBiology(float biology) {
		this.biology = biology;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateOfAdmission=" + dateOfAdmission + ", physics=" + physics
				+ ", chemistry=" + chemistry + ", biology=" + biology + "]";
	}


	
   
 
    // other getters and setters...
}

