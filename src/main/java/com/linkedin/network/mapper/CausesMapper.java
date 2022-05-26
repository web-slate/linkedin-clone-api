package com.linkedin.network.mapper;

import com.linkedin.network.dto.CausesDTO;
import com.linkedin.network.entity.Causes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CausesMapper {

	CausesMapper INSTANCE = Mappers.getMapper(CausesMapper.class);

	List<CausesDTO> toDtoList(List<Causes> causes);

	@Mapping(source = "causeId", target = "causeIdentifier")
	CausesDTO toDto(Causes cause);
}