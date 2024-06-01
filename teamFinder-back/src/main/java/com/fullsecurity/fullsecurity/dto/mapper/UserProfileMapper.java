package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.UserProfileDto;
import com.fullsecurity.fullsecurity.models.UserProfile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends BaseEntityMapper<UserProfileDto, UserProfile>{

    UserProfileDto toDto(UserProfile userProfile);

    UserProfile toEntity(UserProfileDto userProfileDto);

    List<UserProfile> toEntity(List<UserProfileDto> dtoList);

    List<UserProfileDto> toDto(List<UserProfile> entityList);
}
