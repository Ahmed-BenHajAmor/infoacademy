package com.infoacademy.infoacademy.domaine.mappers;


import com.infoacademy.infoacademy.domaine.dtos.video.UploadVideoRequest;
import com.infoacademy.infoacademy.domaine.dtos.video.VideoResponse;
import com.infoacademy.infoacademy.domaine.entities.Video;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VideoMapper {
    VideoResponse toDto(Video video);

    Video toEntity(UploadVideoRequest uploadVideoRequest);
}
