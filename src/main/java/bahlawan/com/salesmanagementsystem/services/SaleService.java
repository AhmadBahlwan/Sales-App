package bahlawan.com.salesmanagementsystem.services;


import bahlawan.com.salesmanagementsystem.dtos.CreateSaleRequest;

import bahlawan.com.salesmanagementsystem.dtos.UpdateSaleRequest;
import bahlawan.com.salesmanagementsystem.models.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();

    Sale create(CreateSaleRequest request);

    Sale update(int saleId, UpdateSaleRequest request);
}
