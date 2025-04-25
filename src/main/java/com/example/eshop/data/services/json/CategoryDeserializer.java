package com.example.eshop.data.services.json;

import com.example.eshop.data.services.CategoryService;
import com.example.eshop.entities.Category;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {

	@Autowired
	private CategoryService categoryService;

	@Override
	public Category deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		TextNode node = (TextNode) jp.getCodec().readTree(jp);  // Получаем строку из JSON
		Integer categoryId = Integer.parseInt(node.asText());  // Преобразуем строку в Integer

		// Получаем категорию из базы данных по ID
		return categoryService.findById(categoryId);
	}
}