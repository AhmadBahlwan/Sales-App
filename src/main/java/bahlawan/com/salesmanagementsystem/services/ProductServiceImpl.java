package bahlawan.com.salesmanagementsystem.services;

import bahlawan.com.salesmanagementsystem.dtos.ProductRequest;
import bahlawan.com.salesmanagementsystem.models.Product;
import bahlawan.com.salesmanagementsystem.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product newProduct = new Product();
        this.prepare(newProduct,request);
        return repository.save(newProduct);
    }

    @Override
    public Product update(int id, ProductRequest request){
        Product existingProduct = repository.findById(id)
                .orElseThrow(()->new RuntimeException("no products with this id"));
        this.prepare(existingProduct,request);
        return repository.save(existingProduct);
    }

    private Product prepare(Product product, ProductRequest request){
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        return product;
    }


}
