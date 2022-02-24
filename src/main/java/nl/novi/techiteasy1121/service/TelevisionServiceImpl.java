package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionServiceImpl implements TelevisionService {

    private final TelevisionRepository repository;

    public TelevisionServiceImpl( TelevisionRepository repository ) {
        this.repository = repository;
    }

    //    Methode Robert-Jan
    @Override
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> lt = this.repository.findAll();
        List<TelevisionDto> ltdto = new ArrayList<>();

        lt.forEach( t -> ltdto.add( new TelevisionDto( t.getId(), t.getType(), t.getBrand(), t.getName(), t.getPrice(), t.getAvailableSize(), t.getRefreshRate(), t.getScreenType(), t.getScreenQuality(), t.getSmartTv(), t.getWifi(), t.getVoiceControl(), t.getHdr(), t.getBluetooth(), t.getAmbiLight(), t.getOriginalStock(), t.getSold() ) ) );

        return ltdto;
    }
//    @Override
//    public List<TelevisionDto> getAllTelevisions() {
//        List<Television> tvList = televisionRepository.findAll();
//        List<TelevisionDto> tvDtoList = new ArrayList<>();
//        TelevisionDto dto = new TelevisionDto();
//
//        for ( Television tv : tvList ) {
//            dto.setId( tv.getId() );
//            dto.setType( tv.getType() );
//            dto.setBrand( tv.getBrand() );
//            dto.setName( tv.getName() );
//            dto.setPrice( tv.getPrice() );
//            dto.setAvailableSize( tv.getAvailableSize() );
//            dto.setRefreshRate( tv.getRefreshRate() );
//            dto.setScreenType( tv.getScreenType() );
//            dto.setScreenQuality( tv.getScreenQuality() );
//            dto.setSmartTv( tv.getSmartTv() );
//            dto.setWifi( tv.getWifi() );
//            dto.setVoiceControl( tv.getVoiceControl() );
//            dto.setHdr( tv.getHdr() );
//            dto.setBluetooth( tv.getBluetooth() );
//            dto.setAmbiLight( tv.getAmbiLight() );
//            dto.setOriginalStock( tv.getOriginalStock() );
//            dto.setSold( tv.getSold() );
//
////            Add tv(dto) to a list(tvDtoList)
//            tvDtoList.add(dto);
//        }
//        return tvDtoList;
//    }

    @Override
    public TelevisionDto getTelevisionById( Long id ) {
        TelevisionDto dto = new TelevisionDto();
        if ( repository.findById( id ).isPresent() ) {
            Television tv = repository.findById( id ).get();
            dto.setId( tv.getId() );
            dto.setType( tv.getType() );
            dto.setBrand( tv.getBrand() );
            dto.setName( tv.getName() );
            dto.setPrice( tv.getPrice() );
            dto.setAvailableSize( tv.getAvailableSize() );
            dto.setRefreshRate( tv.getRefreshRate() );
            dto.setScreenType( tv.getScreenType() );
            dto.setScreenQuality( tv.getScreenQuality() );
            dto.setSmartTv( tv.getSmartTv() );
            dto.setWifi( tv.getWifi() );
            dto.setVoiceControl( tv.getVoiceControl() );
            dto.setHdr( tv.getHdr() );
            dto.setBluetooth( tv.getBluetooth() );
            dto.setAmbiLight( tv.getAmbiLight() );
            dto.setOriginalStock( tv.getOriginalStock() );
            dto.setSold( tv.getSold() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Geen tv gevonden" );
        }
    }

    @Override
    public Television addTelevision( TelevisionDto televisionDto ) {
        Television t = new Television();
        t.setId( televisionDto.getId() );
        t.setType( televisionDto.getType() );
        t.setBrand( televisionDto.getBrand() );
        t.setName( televisionDto.getName() );
        t.setPrice( televisionDto.getPrice() );
        t.setAvailableSize( televisionDto.getAvailableSize() );
        t.setRefreshRate( televisionDto.getRefreshRate() );
        t.setScreenType( televisionDto.getScreenType() );
        t.setScreenQuality( televisionDto.getScreenQuality() );
        t.setSmartTv( televisionDto.getSmartTv() );
        t.setWifi( televisionDto.getWifi() );
        t.setVoiceControl( televisionDto.getVoiceControl() );
        t.setHdr( televisionDto.getHdr() );
        t.setBluetooth( televisionDto.getBluetooth() );
        t.setAmbiLight( televisionDto.getAmbiLight() );
        t.setOriginalStock( televisionDto.getOriginalStock() );
        t.setSold( televisionDto.getSold() );
        return this.repository.save( t );
    }

    @Override
    public void deleteTelevisionById( Long id ) {

                repository.deleteById( id );

    }
        @Override
        public TelevisionDto updateTelevision ( Long id, TelevisionDto dto){
            if ( repository.findById( id ).isPresent() ) {

                Television tv = repository.findById( id ).get();

                tv.setId( tv.getId() );
                tv.setType( dto.getType() );
                tv.setBrand( dto.getBrand() );
                tv.setName( dto.getName() );
                tv.setPrice( dto.getPrice() );
                tv.setAvailableSize( dto.getAvailableSize() );
                tv.setRefreshRate( dto.getRefreshRate() );
                tv.setScreenType( dto.getScreenType() );
                tv.setScreenQuality( dto.getScreenQuality() );
                tv.setSmartTv( dto.getSmartTv() );
                tv.setWifi( dto.getWifi() );
                tv.setVoiceControl( dto.getVoiceControl() );
                tv.setHdr( dto.getHdr() );
                tv.setBluetooth( dto.getBluetooth() );
                tv.setAmbiLight( dto.getAmbiLight() );
                tv.setOriginalStock( dto.getOriginalStock() );
                tv.setSold( dto.getSold() );
                repository.save( tv );
                return dto;
            } else {
                throw new RecordNotFoundException( "geen televisie gevonden" );
            }
        }
    }
