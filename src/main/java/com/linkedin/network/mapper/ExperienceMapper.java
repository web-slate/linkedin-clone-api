package com.linkedin.network.mapper;

import com.linkedin.network.dto.ExperienceDTO;
import com.linkedin.network.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExperienceMapper {
    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    @Mapping(source = "experienceId", target = "experienceId")
    List<ExperienceDTO> toDto(List<Experience> experiences);
}
