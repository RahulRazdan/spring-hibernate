package com.practice.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePicture {

	private MultipartFile picture;

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

}
