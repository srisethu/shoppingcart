/**
 *
 */
package com.mindtree.springboot.shoppingcart.service.impl;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mindtree.springboot.shoppingcart.dao.ProductDao;
import com.mindtree.springboot.shoppingcart.model.*;
import com.mindtree.springboot.shoppingcart.service.ProductService;

/**
 * The Class ProductServiceImpl.
 *
 * @author Sridevi Uppala
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    /** LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    /** The product dao. */
    @Autowired
    private ProductDao productDao;

    /**
     *fetchProducts
     */
    @Override
    public Map<String, List<Product>> fetchProducts() {
        Map<String, List<Product>> productMap = new TreeMap<String, List<Product>>();
        List<Product> products = productDao.fetchAllProduct();
        for (Product product : products) {
            updateProductType(productMap, product);
        }
        return productMap;
    }


    /**
     * @param productMap
     * @param product
     */
    private void updateProductType(Map<String, List<Product>> productMap, Product product) {
        String productType = null;
        if (product instanceof Book ) {
            productType = "BOOK";
        } else if (product instanceof Apparel ) {
            productType = "APPAREL";
        }
        if (productType != null) {
            List<Product> productList = null;
            if (productMap.get(productType) != null) {
                productList = productMap.get(productType);
            } else {
                productList = new ArrayList<Product>();
                productMap.put(productType, productList);
            }
            productList.add(product);
        }
    }


    /**
     *fetchProductTypes
     */
    @Override
    public List<String> getProductTypes() {
        return productDao.fetchAllProductType();
    }


    /**
     *fetchProductTypesByCriteria
     */
    @Override
    public Map<String, List<Product>> searchProducts(ProductSearch productSearch) {
        LOGGER.info("fetch Product Types by Criteria");
        Map<String, List<Product>> productMap = new TreeMap<String, List<Product>>();
        List<Product> products = null;
        if (productSearch.getProductId() != null) {
            Optional<Product> product = productDao.fetchProductById(productSearch.getProductId());
            if (product.isPresent()) {
                products = new ArrayList<>();
                products.add(product.get());
                if (!StringUtils.isEmpty(productSearch.getProductName())) {
                    if (!product.get().getName().equalsIgnoreCase(productSearch.getProductName())) {
                        products.remove(product.get());
                    }
                }
            }
        } else if (!StringUtils.isEmpty(productSearch.getProductName())) {
            products = productDao.fetchProductByName(productSearch.getProductName());
        } else {
            products = productDao.fetchAllProduct();
        }
        if (products != null) {
            for (Product product : products) {
                updateProductType(productMap, product);
            }
        }
        if (!StringUtils.isEmpty(productSearch.getProductType())) {
            productMap.keySet().removeIf(key-> !key.equalsIgnoreCase(productSearch.getProductType()));
        }
        return productMap;
    }


    /**
     * Find all ordered by name descending.
     *
     * @return the list
     */
    @Override
    public List<Product> findAllOrderedByNameDescending() {
        return productDao.findAllOrderedByNameDescending();
    }

}
