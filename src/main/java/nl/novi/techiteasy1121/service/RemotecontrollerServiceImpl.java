package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.RemotecontrollerDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Remotecontroller;
import nl.novi.techiteasy1121.repositories.RemotecontrollerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemotecontrollerServiceImpl implements RemotecontrollerService {

    private final RemotecontrollerRepository rcRepository;

    public RemotecontrollerServiceImpl( RemotecontrollerRepository rcRepository ) {
        this.rcRepository = rcRepository;
    }

    //    Methode Robert-Jan
    @Override
    public List<RemotecontrollerDto> getAllRemotecontrollers() {
        List<Remotecontroller> lrc = this.rcRepository.findAll();
        List<RemotecontrollerDto> lrcdto = new ArrayList<>();

        lrc.forEach( t -> lrcdto.add( new RemotecontrollerDto( t.getId(), t.getCompatibleWith(), t.getBatteryType(), t.getName(), t.getBrand(), t.getPrice(), t.getOriginalStock() ) ) );

        return lrcdto;
    }

    @Override
    public RemotecontrollerDto getRemotecontrollerById( Long id ) {
        RemotecontrollerDto dto = new RemotecontrollerDto();
        if ( rcRepository.findById( id ).isPresent() ) {
            Remotecontroller rc = rcRepository.findById( id ).get();
            dto.setId( rc.getId() );
            dto.setCompatibleWith( rc.getCompatibleWith() );
            dto.setBrand( rc.getBrand() );
            dto.setBatteryType( rc.getBatteryType() );
            dto.setName( rc.getName() );
            dto.setPrice( rc.getPrice() );
            dto.setOriginalStock( rc.getOriginalStock() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Geen tv gevonden" );
        }
    }

    @Override
    public Remotecontroller addRemotecontroller( RemotecontrollerDto remoteControllerDto ) {
        Remotecontroller rc = new Remotecontroller();
        rc.setId( remoteControllerDto.getId() );
        rc.setCompatibleWith( remoteControllerDto.getCompatibleWith() );
        rc.setBrand( remoteControllerDto.getBrand() );
        rc.setBatteryType( remoteControllerDto.getBatteryType() );
        rc.setName( remoteControllerDto.getName() );
        rc.setPrice( remoteControllerDto.getPrice() );
        rc.setOriginalStock( remoteControllerDto.getOriginalStock() );
        return this.rcRepository.save( rc );
    }


    @Override
    public void deleteRemotecontrollerById( Long id ) {

        rcRepository.deleteById( id );

    }

    @Override
    public RemotecontrollerDto updateRemotecontroller ( Long id, RemotecontrollerDto dto){
        if ( rcRepository.findById( id ).isPresent() ) {

            Remotecontroller rc = rcRepository.findById( id ).get();

            rc.setId( rc.getId() );
            rc.setBrand( dto.getBrand() );
            rc.setName( dto.getName() );
            rc.setPrice( dto.getPrice() );
            rc.setBatteryType( dto.getBatteryType() );
            rc.setCompatibleWith( dto.getCompatibleWith() );
            rc.setOriginalStock( dto.getOriginalStock() );
            rcRepository.save( rc );
            return dto;
        } else {
            throw new RecordNotFoundException( "geen televisie gevonden" );
        }
    }


}
