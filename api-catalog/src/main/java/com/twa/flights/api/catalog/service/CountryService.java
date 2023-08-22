package com.twa.flights.api.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.twa.flights.api.catalog.dto.CountryDTO;
import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.model.Country;
import com.twa.flights.api.catalog.repository.CountryRepository;
import com.twa.flights.api.catalog.enums.ExceptionStatus;

import ma.glasnost.orika.MapperFacade;

@Service
public class CountryService {
    CountryRepository countryRepository;
    MapperFacade mapper;

    @Autowired
    public CountryService(CountryRepository countryRepository, MapperFacade mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    public CountryDTO getCountryByCode(String code) {
        Country country = countryRepository.findByCode(code);

        if (country == null) {
            throw new APIException(HttpStatus.NOT_FOUND, ExceptionStatus.COUNTRY_NOT_FOUND.getCode(),
                    ExceptionStatus.COUNTRY_NOT_FOUND.getMessage());
        }
        mapper.map(country, CountryDTO.class);
        return new CountryDTO();
    }

    public CountryDTO save(CountryDTO country) {
        Country entityToPersist = mapper.map(country, Country.class);

        Country entityToPersisted = countryRepository.save(entityToPersist);

        return mapper.map(entityToPersisted, CountryDTO.class);
    }
}
