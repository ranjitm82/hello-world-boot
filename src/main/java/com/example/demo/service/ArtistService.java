package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ArtistRequest;
import com.example.demo.model.Address;
import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArtistService {

	private final ArtistRepository artistRepository;
	
	@Transactional
	public Artist createArtist(ArtistRequest request) {
		
		request.getAddress();
		
		Address address = new Address();
		address.setStreet(request.getAddress().getStreet());
		address.setCountry(request.getAddress().getCountry());
		
		Artist artist = new Artist();
		artist.setFirstName(request.getFirstName());
		artist.setLastName(request.getLastName());
		artist.setAddress(address);
		artist.setBirthDate(request.getBirthDate());
		
		return artistRepository.save(artist);
	}
	
	public List<Artist> getArtist() {
		return artistRepository.findAll();
	}
}
