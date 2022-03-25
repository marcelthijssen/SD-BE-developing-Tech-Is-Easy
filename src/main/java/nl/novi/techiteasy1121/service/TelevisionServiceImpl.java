package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.CiModuleRepository;
import nl.novi.techiteasy1121.repositories.RemotecontrollerRepository;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;

import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionServiceImpl implements TelevisionService {

    private final TelevisionRepository tvRepository;
    private final RemotecontrollerRepository rcRepository;
    private final WallBracketRepository wbRepository;
    private final CiModuleRepository cmRepository;

    public TelevisionServiceImpl( TelevisionRepository tvRepository, RemotecontrollerRepository rcRepository, CiModuleRepository cmRepository, WallBracketRepository wbRepository ) {
        this.tvRepository = tvRepository;
        this.rcRepository = rcRepository;
        this.wbRepository = wbRepository;
        this.cmRepository = cmRepository;
    }

    @Override
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = this.tvRepository.findAll();
        List<TelevisionDto> ltdto = new ArrayList<>();

        for ( Television tv : tvList ) {
            TelevisionDto dto = new TelevisionDto();
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
            dto.setCiModule( tv.getCiModule() );
            dto.setRemotecontroller( tv.getRemotecontroller() );
            dto.setWallBrackets( tv.getWallBrackets() );
            ltdto.add( dto );
        }
        return ltdto;
//
//        lt.forEach( t -> ltdto.add( new TelevisionDto( t.getId(), t.getType(), t.getBrand(), t.getName(), t.getPrice(), t.getAvailableSize(), t.getRefreshRate(), t.getScreenType(), t.getScreenQuality(), t.getSmartTv(), t.getWifi(), t.getVoiceControl(), t.getHdr(), t.getBluetooth(), t.getAmbiLight(), t.getOriginalStock(), t.getSold() ) ) );
//
//        return ltdto;
    }

    @Override
    public TelevisionDto getTelevisionById( Long id ) {
        TelevisionDto dto = new TelevisionDto();
        if ( tvRepository.findById( id ).isPresent() ) {
            Television tv = tvRepository.findById( id ).get();
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
//            Added Manually after @OneToOne etc
            dto.setSold( tv.getSold() );
            dto.setCiModule( tv.getCiModule() );
            dto.setRemotecontroller( tv.getRemotecontroller() );
            dto.setWallBrackets( tv.getWallBrackets() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Geen tv gevonden" );
        }
    }

    @Override
    public Television addTelevision( TelevisionDto televisionDto ) {
        Television tv = new Television();
        tv.setId( televisionDto.getId() );
        tv.setType( televisionDto.getType() );
        tv.setBrand( televisionDto.getBrand() );
        tv.setName( televisionDto.getName() );
        tv.setPrice( televisionDto.getPrice() );
        tv.setAvailableSize( televisionDto.getAvailableSize() );
        tv.setRefreshRate( televisionDto.getRefreshRate() );
        tv.setScreenType( televisionDto.getScreenType() );
        tv.setScreenQuality( televisionDto.getScreenQuality() );
        tv.setSmartTv( televisionDto.getSmartTv() );
        tv.setWifi( televisionDto.getWifi() );
        tv.setVoiceControl( televisionDto.getVoiceControl() );
        tv.setHdr( televisionDto.getHdr() );
        tv.setBluetooth( televisionDto.getBluetooth() );
        tv.setAmbiLight( televisionDto.getAmbiLight() );
        tv.setOriginalStock( televisionDto.getOriginalStock() );
        tv.setSold( televisionDto.getSold() );
        return this.tvRepository.save( tv );
    }

    @Override
    public void deleteTelevisionById( Long id ) {

        tvRepository.deleteById( id );

    }

    @Override
    public TelevisionDto updateTelevision( Long id, TelevisionDto dto ) {
        if ( tvRepository.findById( id ).isPresent() ) {

            Television tv = tvRepository.findById( id ).get();

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
            tvRepository.save( tv );
            return dto;
        } else {
            throw new RecordNotFoundException( "geen televisie gevonden" );
        }
    }

    @Override
    public void assignRemotecontrollerToTelevision( Long id, Long rcid ) {
        var optionalTelevision = tvRepository.findById( id );
        var optionalRemotecontroller = rcRepository.findById( rcid );

        if ( optionalTelevision.isPresent() && optionalRemotecontroller.isPresent() ) {
            var television = optionalTelevision.get();
            var remotecontroller = optionalRemotecontroller.get();

            television.setRemotecontroller( remotecontroller );
            tvRepository.save( television );
        } else {
            throw new RecordNotFoundException( "tv of rc bestaat niet" );
        }
    }

    @Override
    public void assignCiModuleToTelevision( Long id, Long cmid ) {
        var optionalTelevision = tvRepository.findById( id );
        var optionalCiModule = cmRepository.findById( cmid );

        if ( optionalTelevision.isPresent() && optionalCiModule.isPresent() ) {
            var television = optionalTelevision.get();
            var ciModule = optionalCiModule.get();

            television.setCiModule( ciModule );
            tvRepository.save( television );
        } else {
            throw new RecordNotFoundException( "tv of rc bestaat niet" );
        }
    }

    @Override
    public void assignWallBracketToTelevision( Long id, Long wbid ) {
        var optionalTelevision = tvRepository.findById( id );
        var optionalWallBracket = wbRepository.findById( wbid );

        if ( optionalTelevision.isPresent() && optionalWallBracket.isPresent() ) {
            var television = optionalTelevision.get();
            var wallBracket = optionalWallBracket.get();

            television.getWallBrackets().add( wallBracket );
            tvRepository.save( television );
        } else {
            throw new RecordNotFoundException( "tv of wb bestaat niet" );
        }
    }

}
