package com.tech.ecomerce.controler;

import com.tech.ecomerce.model.products;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControler {

    @GetMapping("produto")
    public products getProduct() {
        products p=new products("rtx Shibuya" ,"muito potente e feita para codigo" ,1000);
        return p;
    }
}
