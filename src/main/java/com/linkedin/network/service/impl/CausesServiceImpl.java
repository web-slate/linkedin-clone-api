package com.linkedin.ProfessionalNetworking.service.impl;

import com.linkedin.ProfessionalNetworking.dto.CausesRequest;
import com.linkedin.ProfessionalNetworking.model.Causes;
import com.linkedin.ProfessionalNetworking.repository.CausesRepository;
import com.linkedin.ProfessionalNetworking.service.CausesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CausesServiceImpl implements CausesService {

    @Autowired
    CausesRepository causesRepository;

    @Override
    public List<Causes> getCausesByUserId(String userId) {
        return causesRepository.findByUserId(userId);
    }

    @Override
    public Causes updateCauseByCauseId(CausesRequest causesRequest) {
        Causes updatedCauses = new Causes();
        updatedCauses.setCauseId(causesRequest.getCauseId());
        updatedCauses.setUserId(causesRequest.getUserId());
        updatedCauses.setCause(causesRequest.getCause());
        causesRepository.save(updatedCauses);
        return updatedCauses;
    }

    @Override
    public List<Causes> createCause(CausesRequest causesRequest) {
        Causes causesPayload = new Causes();
        causesPayload.setUserId(causesRequest.getUserId());
        causesPayload.setCause(causesRequest.getCause());
        causesRepository.save(causesPayload);
        return null;
    }
}
