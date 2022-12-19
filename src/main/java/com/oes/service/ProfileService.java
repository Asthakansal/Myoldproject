package com.oes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oes.entity.Profile;



@Service
public interface ProfileService {

	public Profile addProfile(Profile profile);
	
	public List<Profile> getUserProfile()throws Exception;
}