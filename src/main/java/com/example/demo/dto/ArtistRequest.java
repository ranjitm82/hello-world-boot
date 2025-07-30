package com.example.demo.dto;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class ArtistRequest {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private AddressDto address;
	
	private ZonedDateTime birthDate;

}

