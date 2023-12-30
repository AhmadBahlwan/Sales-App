package bahlawan.com.salesmanagementsystem.controllers;

import bahlawan.com.salesmanagementsystem.dtos.CreateSaleRequest;
import bahlawan.com.salesmanagementsystem.dtos.UpdateSaleRequest;
import bahlawan.com.salesmanagementsystem.models.Sale;
import bahlawan.com.salesmanagementsystem.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;
    
    @GetMapping
    public List<Sale> getAllSales(){
        return saleService.getAllSales();
    }

    @PostMapping
    public Sale create(@RequestBody CreateSaleRequest request){
        return saleService.create(request);
    }

    @PatchMapping("/{id}")
    public Sale update(@PathVariable int id, @RequestBody UpdateSaleRequest request){
        return saleService.update(id,request);
    } 
}
