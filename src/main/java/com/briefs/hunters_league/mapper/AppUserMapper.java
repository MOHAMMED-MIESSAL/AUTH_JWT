package com.briefs.hunters_league.mapper;


import com.briefs.hunters_league.domain.AppUser;
import com.briefs.hunters_league.vm.AppUserVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserVM toAppUserVM(AppUser appUser);
}
