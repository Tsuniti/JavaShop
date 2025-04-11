package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.ImageRepository;
import com.example.eshop.data.repositories.OrderItemRepository;
import com.example.eshop.data.services.ImageService;
import com.example.eshop.entities.Image;
import com.example.eshop.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceDb implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Image save(Image image) {
		return imageRepository.save(image);
	}

	@Override
	public void delete(Integer id) {
		imageRepository.deleteById(id);
	}
}
