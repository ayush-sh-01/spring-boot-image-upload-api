package new_spring_project.second_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import new_spring_project.second_project.entity.Products;
import new_spring_project.second_project.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	private final ProductService service;

	@GetMapping
	public Products createProduct(@RequestParam String name, @RequestParam("file") MultipartFile file) {
		return service.createProduct(name, file);
	}
}