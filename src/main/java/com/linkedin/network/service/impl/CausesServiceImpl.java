package com.linkedin.network.service.impl;

import com.linkedin.network.dto.*;
import com.linkedin.network.mapper.*;
import com.linkedin.network.entity.Causes;
import com.linkedin.network.repository.CausesRepository;
import com.linkedin.network.service.CausesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CausesServiceImpl implements CausesService {

    @Autowired
    private CausesRepository causesRepository;

    @Override
    public List<CausesDTO> getCausesByUserId(String userId) {
        List<Causes> causes = causesRepository.findByUserId(userId);
        return CausesMapper.INSTANCE.toDtoList(causes);
    }

    @Override
    public Causes updateCauseByCauseId(Long causeId, CausesRequest causesRequest) {
        Optional<Causes> existingCause = Optional.of(causesRepository.getById(causeId));
        if(existingCause.isPresent()) {
            Causes updatedCauses = existingCause.get();
            updatedCauses.setUserId(causesRequest.getUserId());
            updatedCauses.setCause(causesRequest.getCause());
            causesRepository.save(updatedCauses);
        }
        return null;
    }

    @Override
    public Causes createCause(CausesRequest causesRequest) {
        Causes causesPayload = new Causes();
        causesPayload.setUserId(causesRequest.getUserId());
        causesPayload.setCause(causesRequest.getCause());
        causesRepository.save(causesPayload);
        return causesPayload;
    }
}
