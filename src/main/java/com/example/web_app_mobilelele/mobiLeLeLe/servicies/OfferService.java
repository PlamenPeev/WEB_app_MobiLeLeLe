package com.example.web_app_mobilelele.mobiLeLeLe.servicies;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.dtos.AddOfferDTO;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.Model;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.Offer;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.User;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.mapper.OfferMapper;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.user.CurrentUser;
import com.example.web_app_mobilelele.mobiLeLeLe.repositories.ModelRepository;
import com.example.web_app_mobilelele.mobiLeLeLe.repositories.OfferRepository;
import com.example.web_app_mobilelele.mobiLeLeLe.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private UserRepository userRepository;

    private final ModelRepository modelRepository;
    private CurrentUser currentUser;
    private OfferMapper offerMapper;


    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        ModelRepository modelRepository, CurrentUser currentUser,
                        OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        Offer newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

//TODO currentUser should be logged in
        User seller = userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow();

        Model model = modelRepository
                .findById(addOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);


    }


}
