package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.WallBracketDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketServiceImpl implements WallBracketService {

    private final WallBracketRepository repository;

    public WallBracketServiceImpl( WallBracketRepository repository ) {
        this.repository = repository;
    }

    //    Methode Robert-Jan
    @Override
    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wb = this.repository.findAll();
        List<WallBracketDto> wbdto = new ArrayList<>();

        wb.forEach( t -> wbdto.add( new WallBracketDto(  t.getId(), t.getSize(), t.getAdjustable(), t.getName(), t.getPrice() ) ) );

        return wbdto;
    }


    @Override
    public WallBracketDto getWallBracketById( Long id ) {
        WallBracketDto dto = new WallBracketDto();
        if ( repository.findById( id ).isPresent() ) {
            WallBracket wb = repository.findById( id ).get();
            dto.setId( wb.getId() );
            dto.setSize( wb.getSize() );
            dto.setAdjustable ( wb.getAdjustable() );
            dto.setName( wb.getName() );
            dto.setPrice( wb.getPrice() );

            return dto;
        } else {
            throw new RecordNotFoundException( "Geen wb gevonden" );
        }
    }

    @Override
    public WallBracket addWallBracket( WallBracketDto wallBracketDto ) {
        WallBracket wb = new WallBracket();
        wb.setId( wallBracketDto.getId() );
        wb.setName( wallBracketDto.getName() );
        wb.setSize( wallBracketDto.getSize() );
        wb.setPrice( wallBracketDto.getPrice() );
        wb.setAdjustable( wallBracketDto.getAdjustable() );

        return this.repository.save( wb );
    }

    @Override
    public void deleteWallBracketById( Long id ) {

        repository.deleteById( id );

    }

    @Override
    public WallBracketDto updateWallBracket( Long id, WallBracketDto dto ) {
        if ( repository.findById( id ).isPresent() ) {

            WallBracket wb = repository.findById( id ).get();

           wb.setId( wb.getId() );
           wb.setName( dto.getName() );
           wb.setPrice( dto.getPrice() );
           wb.setAdjustable( dto.getAdjustable() );

            repository.save( wb );
            return dto;
        } else {
            throw new RecordNotFoundException( "geen WallBracket gevonden" );
        }
    }

}
