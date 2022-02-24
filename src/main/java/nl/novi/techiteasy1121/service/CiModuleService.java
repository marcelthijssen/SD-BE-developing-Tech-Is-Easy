package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.CiModuleDto;
import nl.novi.techiteasy1121.models.CiModule;

import java.util.List;

public interface CiModuleService {
    List<CiModuleDto> getAllCiModules();

    CiModuleDto getCiModuleById( Long id );

    CiModule addCiModule( CiModuleDto ciModuleDto );

    void deleteCiModuleById( Long id );

    CiModuleDto updateCiModule( Long id, CiModuleDto dto );
}
