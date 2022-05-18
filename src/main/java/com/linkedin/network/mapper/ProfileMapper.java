package com.linkedin.network.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

@Mapper
public interface ProfileMapper {

	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	@Mapping(source = "profileId", target = "id")
	ProfileDTO toDto(Profile profile);
}
