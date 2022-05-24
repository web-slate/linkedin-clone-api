package com.linkedin.network.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;

import com.linkedin.network.dto.*;
import com.linkedin.network.entity.*;
import java.util.List;

@Mapper
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mapping(source = "skillId", target = "id")
    List<SkillsDTO> toDto(List<Skills> skill);
}
