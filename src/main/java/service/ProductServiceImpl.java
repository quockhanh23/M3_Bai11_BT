package service;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private List<Product> productList;

    public ProductServiceImpl(List<Product> productList) {
        this.productList = productList;
    }

    public ProductServiceImpl() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "khanh1", 100));
        productList.add(new Product(2, "khanh2", 100));
        productList.add(new Product(3, "khanh3", 100));
        productList.add(new Product(4, "khanh4", 100));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndexById2(id);
        productList.set(index, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(findIndexById2(id));
    }

    public int findIndexById2(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }
    public List<Product> findByName (String name) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().matches(name+".*")) {
              list.add(productList.get(i));
            }
        }
        return list;
    }
    public List<Product> findByPrice (double min, double max) {
       List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if ((productList.get(i).getPrice() <= max) && (productList.get(i).getPrice() >= min)) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }
}
