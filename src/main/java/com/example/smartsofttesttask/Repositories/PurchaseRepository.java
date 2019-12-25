package com.example.smartsofttesttask.Repositories;

import com.example.smartsofttesttask.Domains.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository
        extends CrudRepository<Purchase, Long>  {
}
