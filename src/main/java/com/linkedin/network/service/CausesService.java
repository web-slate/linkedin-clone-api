package com.linkedin.network.service;

import com.linkedin.network.dto.CausesDTO;
import com.linkedin.network.dto.CausesRequest;
import com.linkedin.network.entity.Causes;
import java.util.List;
public interface CausesService {

    List<CausesDTO> getCausesByUserId(String userId);
    Causes updateCauseByCauseId(Long causeId, CausesRequest causesRequest);
    Causes createCause(CausesRequest causesRequest);
}
