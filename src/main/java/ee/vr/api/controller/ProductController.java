package ee.vr.api.controller;

import ee.vr.api.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    List<String> cars = new ArrayList<>(Arrays.asList("Tesla", "Nobe", "BMW"));

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Tesla", 85000),
            new Product("Nobe", 25000),
            new Product("BMW", 50000)
    ));

    @GetMapping("product")
    public Product getProduct() {
        return new Product();
    }

    // 1 k6ikide toodete v6tmine listist

    @GetMapping("get-products")
    public List<Product> getProducts() {
        return products;
    }

    // 2 yhe toote kustutamine listist, v6ttes j2rjekorranri

    @GetMapping("delete-product/{index}")
    public List<Product> deleteProduct(@PathVariable int index) {
        products.remove(index);
        return products;
    }


    // 3 yhte toote lisamine listis, v6ttes nime ja hinna

    @GetMapping("add-product")
    public List<Product> addProduct(@RequestParam String name, @RequestParam double price) {
        products.add(new Product(name, price));
        return products;
    }


}
