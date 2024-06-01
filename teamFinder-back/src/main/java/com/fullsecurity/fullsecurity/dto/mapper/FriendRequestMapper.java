package com.fullsecurity.fullsecurity.dto.mapper;

import com.fullsecurity.fullsecurity.dto.FriendRequestDto;
import com.fullsecurity.fullsecurity.models.FriendRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FriendRequestMapper extends BaseEntityMapper<FriendRequestDto, FriendRequest> {

    FriendRequestDto toDto(FriendRequest friendRequest);

    @Override
    FriendRequest toEntity(FriendRequestDto dto);

    @Override
    List<FriendRequest> toEntity(List<FriendRequestDto> dtoList);

    @Override
    List<FriendRequestDto> toDto(List<FriendRequest> entityList);
}
