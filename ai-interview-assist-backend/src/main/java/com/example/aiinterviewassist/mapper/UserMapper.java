package com.example.aiinterviewassist.mapper;

import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User registerMapper(RegisterRequestDTO registerRequestDTO);
}
