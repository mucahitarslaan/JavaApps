package com.mucahitarslan.application.rest.todo.configuration;

import com.mucahitarslan.application.rest.todo.mapper.ITodoInfoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig
{
    @Bean
    public ITodoInfoMapper getTodoInfoMapper()
    {
        return Mappers.getMapper(ITodoInfoMapper.class);
    }
}
