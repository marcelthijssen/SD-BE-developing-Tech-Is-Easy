package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.models.Television;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TelevisionService {

    List<TelevisionDto> getAllTelevisions();

    TelevisionDto getTelevisionById( Long id );

    Television addTelevision( TelevisionDto televisionDto );

    void deleteTelevisionById( Long id );

    TelevisionDto updateTelevision( Long id, TelevisionDto dto );
}
