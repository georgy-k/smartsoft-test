package com.example.smartsofttesttask.Controllers;

import com.example.smartsofttesttask.Domains.Product;
import com.example.smartsofttesttask.Domains.Purchase;
import com.example.smartsofttesttask.Repositories.ProductRepository;
import com.example.smartsofttesttask.Repositories.PurchaseRepository;
import com.example.smartsofttesttask.Services.XMLValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {


    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductRepository productRepository;

    XMLValidation xmlValidator;

    @PostMapping("/api/purchases")
    public void createEvent
            (@Valid @RequestBody String xml) {

        JAXBContext jaxbContext = null;
        Purchase purchase = null;
        Product product = null;
        try {
            XMLValidation.validateXMLSchema(xml);
            jaxbContext = JAXBContext.newInstance(Purchase.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xml);
            purchase = (Purchase) unmarshaller.unmarshal(reader);
            Jackson2ObjectMapperBuilder.xml();
            Optional<Product> p = productRepository.findById(purchase.getPurchase_item());
            if (p.isPresent()){product =p.get();}
            product.getPurchases().add(purchase);
            purchase.setProduct(product);
            purchaseRepository.save(purchase);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}



