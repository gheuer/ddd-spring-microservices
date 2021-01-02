/*
 * GamesServices.java
 *
 * Copyright 2020
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.demo.vgreviews.impl;

import com.demo.vgreviews.dto.VideoGameDTO;
import com.demo.vgreviews.mappers.VideoGameDTOMapper;
import com.demo.vgreviews.spec.IGamesServices;
import com.demo.vgreviews.spec.IVideoGamesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the service layer to handle video games information.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Service
public class GamesServices implements IGamesServices {

    /**
     * DAO used to retrieve information from a persistence layer.
     */
    @Autowired
    private IVideoGamesDao dao;

    /**
     * Mapper of domain layer objects to DTO
     */
    @Autowired
    private VideoGameDTOMapper mapper;

    /**
     * ${@inheritDoc}
     */
    @Override
    public List<VideoGameDTO> getRegisteredGames() {
        return dao.findRegisteredGames().stream().map(mapper::map).collect(Collectors.toList());
    }
}
