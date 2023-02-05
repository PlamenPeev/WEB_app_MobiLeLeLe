package com.example.web_app_mobilelele.mobiLeLeLe.servicies;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.dtos.BrandDTO;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.dtos.ModelDTO;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.Brand;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.Model;
import com.example.web_app_mobilelele.mobiLeLeLe.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());

    }

    private BrandDTO mapBrand(Brand brandEntity) {
        List<ModelDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());

        return new BrandDTO()
                .setModels(models)
                .setName(brandEntity.getName());


    }

    private ModelDTO mapModel(Model modelEntity){
return new ModelDTO()
        .setId(modelEntity.getId())
        .setName(modelEntity.getName());
    }
}
