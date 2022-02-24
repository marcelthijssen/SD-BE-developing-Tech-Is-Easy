package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.RemoteControllerDto;
import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.models.RemoteController;
import nl.novi.techiteasy1121.models.Television;

import java.util.List;

public interface RemoteControllerService {

    List<RemoteControllerDto> getAllRemoteControllers();

    RemoteControllerDto getRemoteControllerById( Long id );

    RemoteController addRemoteController( RemoteControllerDto remoteControllerDto );

    void deleteRemoteControllerById( Long id );

    RemoteControllerDto updateRemoteController( Long id, RemoteControllerDto dto );
}
