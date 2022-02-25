package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.RemotecontrollerRepository;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TelevisionService {
//
//    @Autowired
//    public TelevisionService (TelevisionRepository tvRepository, RemotecontrollerRepository rcRepository) {
//        this.tvRepository = tvRepository; this.rcRepository = rcRepository;
//    }

    List<TelevisionDto> getAllTelevisions();

    TelevisionDto getTelevisionById( Long id );

    Television addTelevision( TelevisionDto televisionDto );

    void deleteTelevisionById( Long id );

    TelevisionDto updateTelevision( Long id, TelevisionDto dto );

//    oneToOne
//    assignRemotecontrollerToTelevision();
}
