package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.RemotecontrollerDto;
import nl.novi.techiteasy1121.models.Remotecontroller;

import java.util.List;

public interface RemotecontrollerService {

    List<RemotecontrollerDto> getAllRemotecontrollers();

    RemotecontrollerDto getRemotecontrollerById( Long id );

    Remotecontroller addRemotecontroller( RemotecontrollerDto remotecontrollerDto );

    void deleteRemotecontrollerById( Long id );

    RemotecontrollerDto updateRemotecontroller( Long id, RemotecontrollerDto dto );
}
