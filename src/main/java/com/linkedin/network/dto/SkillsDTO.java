package com.linkedin.network.dto;

import lombok.Data;

@Data
public class SkillsDTO {

    private Long id;

    public String userId;

    public String primarySkill;

    public String secondarySill;
}
