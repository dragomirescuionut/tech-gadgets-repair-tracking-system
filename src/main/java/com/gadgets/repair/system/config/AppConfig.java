package com.gadgets.repair.system.config;

import com.gadgets.repair.system.models.dtos.requests.TicketRequestDTO;
import com.gadgets.repair.system.models.dtos.responses.TicketResponseDTO;
import com.gadgets.repair.system.models.entities.Customer;
import com.gadgets.repair.system.models.entities.Ticket;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return new ModelMapper();
    }

}
