package com.linkedin.network.mapper;

import com.linkedin.network.dto.CausesDTO;
import com.linkedin.network.entity.Causes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CausesMapper {

	CausesMapper INSTANCE = Mappers.getMapper(CausesMapper.class);

	@Mapping(source = "causeId", target = "causeId")
	CausesDTO toDto(Causes causes);
}
