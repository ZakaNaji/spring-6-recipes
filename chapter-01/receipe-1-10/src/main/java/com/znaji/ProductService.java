package com.znaji;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    private  final ProductDao productDao;

    public ProductService(@CustomQualifier("pd2") ProductDao productDao) {
        this.productDao = productDao;
    }

    public void sayHello() {
        productDao.sayHello();
    }

}
