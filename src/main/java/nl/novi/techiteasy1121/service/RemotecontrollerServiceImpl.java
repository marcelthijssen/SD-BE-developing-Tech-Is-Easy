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

    private final RemotecontrollerRepository repository;

    public RemotecontrollerServiceImpl( RemotecontrollerRepository repository ) {
        this.repository = repository;
    }

    //    Methode Robert-Jan
    @Override
    public List<RemotecontrollerDto> getAllRemotecontrollers() {
        List<Remotecontroller> lrc = this.repository.findAll();
        List<RemotecontrollerDto> lrcdto = new ArrayList<>();

        lrc.forEach( t -> lrcdto.add( new RemotecontrollerDto( t.getId(), t.getCompatibleWith(), t.getBatteryType(), t.getName(), t.getBrand(), t.getPrice(), t.getOriginalStock() ) ) );

        return lrcdto;
    }

    @Override
    public RemotecontrollerDto getRemotecontrollerById( Long id ) {
        RemotecontrollerDto dto = new RemotecontrollerDto();
        if ( repository.findById( id ).isPresent() ) {
            Remotecontroller rc = repository.findById( id ).get();
            dto.setId( rc.getId() );
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
        rc.setBrand( remoteControllerDto.getBrand() );
        rc.setName( remoteControllerDto.getName() );
        rc.setPrice( remoteControllerDto.getPrice() );
        rc.setOriginalStock( remoteControllerDto.getOriginalStock() );
        return this.repository.save( rc );
    }

    @Override
    public void deleteRemotecontrollerById( Long id ) {

        repository.deleteById( id );

    }

    @Override
    public RemotecontrollerDto updateRemotecontroller ( Long id, RemotecontrollerDto dto){
        if ( repository.findById( id ).isPresent() ) {

            Remotecontroller rc = repository.findById( id ).get();

            rc.setId( rc.getId() );
            rc.setBrand( dto.getBrand() );
            rc.setName( dto.getName() );
            rc.setPrice( dto.getPrice() );

            rc.setOriginalStock( dto.getOriginalStock() );
            repository.save( rc );
            return dto;
        } else {
            throw new RecordNotFoundException( "geen televisie gevonden" );
        }
    }


}
