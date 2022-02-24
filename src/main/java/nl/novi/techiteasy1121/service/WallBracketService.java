package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.WallBracketDto;
import nl.novi.techiteasy1121.models.WallBracket;

import java.util.List;

public interface WallBracketService {


    List<WallBracketDto> getAllWallBrackets();

    WallBracketDto getWallBracketById( Long id );

    WallBracket addWallBracket( WallBracketDto wallBracketDto );

    void deleteWallBracketById( Long id );

    WallBracketDto updateWallBracket( Long id, WallBracketDto dto );
}
