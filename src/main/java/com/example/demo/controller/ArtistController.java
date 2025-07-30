package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArtistRequest;
import com.example.demo.model.Artist;
import com.example.demo.service.ArtistService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ArtistController {

	private final ArtistService artistService;
	
	
	@PostMapping("/v1/artists")
	public ResponseEntity<Artist> createArtist(@RequestBody ArtistRequest request) throws Exception {
	
		Artist artist = artistService.createArtist(request);
		return ResponseEntity.status(201).body(artist);
	}
	
	@GetMapping("/v1/artists")
	public ResponseEntity<List<Artist>> getArtist() {
		artistService.getArtist();
		return ResponseEntity.ok(artistService.getArtist());
	}
	
	@GetMapping("/artists")
	public ResponseEntity<Void> getArtists() {
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
	            .location(URI.create("/v1/artists"))
	            .build();
	}
}
