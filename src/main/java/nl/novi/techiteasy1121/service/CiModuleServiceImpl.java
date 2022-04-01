package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.CiModuleDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.CiModule;
import nl.novi.techiteasy1121.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiModuleServiceImpl implements CiModuleService {

    private final CiModuleRepository repository;

    public CiModuleServiceImpl( CiModuleRepository repository ) {
        this.repository = repository;
    }

    //    Methode Robert-Jan
    @Override
    public List<CiModuleDto> getAllCiModules() {
        List<CiModule> lcm = this.repository.findAll();
        List<CiModuleDto> lcmdto = new ArrayList<>();

        lcm.forEach( t -> lcmdto.add( new CiModuleDto( t.getId(), t.getType(), t.getName(), t.getPrice() ) ) );

        return lcmdto;
    }

    @Override
    public CiModuleDto getCiModuleById( Long id ) {
        CiModuleDto dto = new CiModuleDto();
        if ( repository.findById( id ).isPresent() ) {
            CiModule cm = repository.findById( id ).get();
            dto.setId( cm.getId() );
            dto.setType( cm.getType() );
            dto.setName( cm.getName() );
            dto.setPrice( cm.getPrice() );
            return dto;
        } else {
            throw new RecordNotFoundException( "No ciModule here" );
        }
    }

    @Override
    public CiModule addCiModule( CiModuleDto ciModuleDto ) {
        CiModule cm = new CiModule();
        cm.setId( ciModuleDto.getId() );
        cm.setType( ciModuleDto.getType() );
        cm.setName( ciModuleDto.getName() );
        cm.setPrice( ciModuleDto.getPrice() );

        return this.repository.save( cm );
    }

    @Override
    public void deleteCiModuleById( Long id ) {
        if ( repository.findById( id ).isPresent() ) {
            repository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Damn, this CiModule does not exist" );
        }
    }

    @Override
    public CiModuleDto updateCiModule( Long id, CiModuleDto dto ) {
        if ( repository.findById( id ).isPresent() ) {

            CiModule cm = repository.findById( id ).get();

            cm.setId( cm.getId() );
            cm.setType( dto.getType() );
            cm.setName( dto.getName() );
            cm.setPrice( dto.getPrice() );

            repository.save( cm );
            return dto;
        } else {
            throw new RecordNotFoundException( "Noi CiModule here, my dear" );
        }
    }
}

