package com.example.eshop.data.services;

import com.example.eshop.entities.Image;

public interface ImageService {
	Image save(Image image);
	void delete(Integer id);
}
