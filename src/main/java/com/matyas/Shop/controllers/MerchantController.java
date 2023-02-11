package com.matyas.Shop.controllers;

import com.matyas.Shop.db.service.api.MerchantService;
import com.matyas.Shop.domain.Merchant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(com.matyas.Shop.db.service.api.MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Merchant> merchantList = merchantService.getMerchants();
        return new ResponseEntity<>(merchantList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Merchant merchant = merchantService.get(id);
        if (merchant != null) {
            return new ResponseEntity<>(merchant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Merchant merchant){
        Integer id = merchantService.add(merchant);
        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
