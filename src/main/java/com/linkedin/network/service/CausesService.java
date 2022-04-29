package com.linkedin.network.service;

import com.linkedin.network.dto.CausesRequest;
import com.linkedin.network.model.Causes;

import java.util.List;

public interface CausesService {

    List<Causes> getCausesByUserId(String userId);

    Causes updateCauseByCauseId(Long causeId, CausesRequest causesRequest);
    Causes createCause(CausesRequest causesRequest);
}
