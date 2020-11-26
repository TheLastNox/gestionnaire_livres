package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(unique = true)
	private String isbn;
	
	@NotNull
	private String title;
	
	@NotNull
	private String author;
	
	@NotNull
	private String editor;
	
	@NotNull
	@Column(name = "description")
	private String desc;
	
	@NotNull
	private Date relDate;
	
	@NotNull
	private boolean available;
}
