package bahlawan.com.salesmanagementsystem.services;

import bahlawan.com.salesmanagementsystem.dtos.CreateSaleRequest;
import bahlawan.com.salesmanagementsystem.dtos.UpdateSaleRequest;
import bahlawan.com.salesmanagementsystem.models.Sale;
import bahlawan.com.salesmanagementsystem.repositories.ClientRepository;
import bahlawan.com.salesmanagementsystem.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepo;

    @Autowired
    private ClientRepository clientRepo;


    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    @Override
    public Sale create(CreateSaleRequest request) {
        Sale newSale = new Sale();
        this.prepare(newSale,request);
        return saleRepo.save(newSale);
    }

    @Override
    public Sale update(int id, UpdateSaleRequest request){
        Sale existingSale = saleRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("no sales with this id"));
        this.prepare(existingSale,request);
        return saleRepo.save(existingSale);
    }

    private void prepare(Sale sale, CreateSaleRequest request){
        sale.setPrice(request.getPrice());
        sale.setQuantity(request.getQuantity());
        sale.setSeller(request.getSeller());
        sale.setClient(clientRepo.findById(request.getClientId())
                .orElseThrow(()-> new RuntimeException("no clients with this id")));
        sale.setTotal(sale.getPrice() * sale.getQuantity());
    }

    private void prepare(Sale sale, UpdateSaleRequest request){
        sale.setPrice(request.getPrice());
        sale.setQuantity(request.getQuantity());
        sale.setTotal(sale.getPrice() * sale.getQuantity());
    }
}
