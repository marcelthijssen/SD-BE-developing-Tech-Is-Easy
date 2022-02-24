package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.RemoteControllerDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.RemoteController;
import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerServiceImpl implements RemoteControllerService {

    private final RemoteControllerRepository repository;

    public RemoteControllerServiceImpl( RemoteControllerRepository repository ) {
        this.repository = repository;
    }

    //    Methode Robert-Jan
    @Override
    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteController> lrc = this.repository.findAll();
        List<RemoteControllerDto> lrcdto = new ArrayList<>();

        lrc.forEach( t -> lrcdto.add( new RemoteControllerDto( t.getId(), t.getCompatibleWith(), t.getBatteryType(), t.getName(), t.getBrand(), t.getPrice(), t.getOriginalStock() ) ) );

        return lrcdto;
    }

    @Override
    public RemoteControllerDto getRemoteControllerById( Long id ) {
        RemoteControllerDto dto = new RemoteControllerDto();
        if ( repository.findById( id ).isPresent() ) {
            RemoteController rc = repository.findById( id ).get();
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
    public RemoteController addRemoteController( RemoteControllerDto remoteControllerDto ) {
        RemoteController rc = new RemoteController();
        rc.setId( remoteControllerDto.getId() );
        rc.setBrand( remoteControllerDto.getBrand() );
        rc.setName( remoteControllerDto.getName() );
        rc.setPrice( remoteControllerDto.getPrice() );
        rc.setOriginalStock( remoteControllerDto.getOriginalStock() );
        return this.repository.save( rc );
    }

    @Override
    public void deleteRemoteControllerById( Long id ) {

        repository.deleteById( id );

    }

    @Override
    public RemoteControllerDto updateRemoteController ( Long id, RemoteControllerDto dto){
        if ( repository.findById( id ).isPresent() ) {

            RemoteController rc = repository.findById( id ).get();

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
