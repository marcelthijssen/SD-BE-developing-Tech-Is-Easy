package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.RemotecontrollerDto;
import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.models.Television;


import java.util.List;

public interface TelevisionService {

    List<TelevisionDto> getAllTelevisions();

    TelevisionDto getTelevisionById( Long id );

    Television addTelevision( TelevisionDto televisionDto );

    void deleteTelevisionById( Long id );

    TelevisionDto updateTelevision( Long id, TelevisionDto dto );

//    oneToOne - Remotecontroller
    void assignRemotecontrollerToTelevision( Long id, Long rcid );

    void assignCiModuleToTelevision(Long id, Long cmid);

//    void assignWallBracketToTelevision(Long id, Long wbid);

}
