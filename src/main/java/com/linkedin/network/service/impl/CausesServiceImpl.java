package com.linkedin.network.service.impl;

import com.linkedin.network.dto.CausesRequest;
import com.linkedin.network.model.Causes;
import com.linkedin.network.repository.CausesRepository;
import com.linkedin.network.service.CausesService;
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
    public Causes updateCauseByCauseId(Long causeId, CausesRequest causesRequest) {
        Causes updatedCauses = new Causes();
        updatedCauses.setCauseId(causeId);
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
