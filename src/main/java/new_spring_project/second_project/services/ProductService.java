package new_spring_project.second_project.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import new_spring_project.second_project.entity.Products;
import new_spring_project.second_project.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository repo;
	private Cloudinary cloudinary;

	public Products createProduct(String name, MultipartFile file) {
		Map uploadResult = null;
		try {
			uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = uploadResult.get("url").toString();

		Products pr = new Products();
		pr.setName(name);
		pr.setUrl(url);

		return repo.save(pr);
	}
}