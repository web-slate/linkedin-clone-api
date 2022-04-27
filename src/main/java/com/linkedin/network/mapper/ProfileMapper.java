package com.linkedin.network.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;

@Mapper
public interface ProfileMapper {
	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	@Mapping(source = "profileId", target = "id")
	@Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
	ProfileDTO toDto(Profile profile);
}
