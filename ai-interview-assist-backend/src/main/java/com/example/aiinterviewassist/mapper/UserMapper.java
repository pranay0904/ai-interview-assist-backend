package com.example.aiinterviewassist.mapper;

import com.example.aiinterviewassist.dto.RegisterRequestDTO;
import com.example.aiinterviewassist.dto.ResumeResponseDTO;
import com.example.aiinterviewassist.dto.UserResponseDTO;
import com.example.aiinterviewassist.entity.Resume;
import com.example.aiinterviewassist.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target="password", ignore = true)
    User registerMapper(RegisterRequestDTO registerRequestDTO);

    UserResponseDTO loginMapper(User user);

    ResumeResponseDTO resumeMapper(Resume resume);

}
