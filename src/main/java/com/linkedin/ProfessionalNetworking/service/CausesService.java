package com.linkedin.ProfessionalNetworking.service;

import com.linkedin.ProfessionalNetworking.dto.CausesRequest;
import com.linkedin.ProfessionalNetworking.model.Causes;

import java.util.List;

public interface CausesService {

    List<Causes> getCausesByUserId(String userId);

    Causes updateCauseByCauseId(CausesRequest causesRequest);
    List<Causes> createCause(CausesRequest causesRequest);
}
