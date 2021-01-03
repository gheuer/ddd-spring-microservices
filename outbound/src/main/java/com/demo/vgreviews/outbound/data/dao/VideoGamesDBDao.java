/*
 * VideoGamesDBDao.java
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
package com.demo.vgreviews.outbound.data.dao;

import com.demo.vgreviews.domain.VideoGame;
import com.demo.vgreviews.outbound.data.entities.VideoGameEntity;
import com.demo.vgreviews.outbound.data.mappers.VideoGameMapper;
import com.demo.vgreviews.outbound.data.repositories.VideoGamesRepository;
import com.demo.vgreviews.spec.IVideoGamesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link com.demo.vgreviews.spec.IVideoGamesDao} using database
 * connection with hibernate.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Component
public class VideoGamesDBDao implements IVideoGamesDao {

    /**
     * Repository instance to manage {@link VideoGameEntity entities}
     */
    @Autowired
    private VideoGamesRepository repository;

    /**
     * Mapper of DB entities to domain classes
     */
    @Autowired
    private VideoGameMapper mapper;

    /**
     * ${@inheritDoc}
     */
    @Override
    public List<VideoGame> findRegisteredGames() {
        List<VideoGameEntity> games;

        games = repository.findAll();

        return games.stream().map(mapper::map).collect(Collectors.toList());
    }

    /**
     * Setter of the repository property. Used in unit tests.
     *
     * @param repository
     *      Repository instance
     */
    void setRepository(VideoGamesRepository repository) {
        this.repository = repository;
    }

    /**
     * Setter of the mapper property. Used in unit tests.
     *
     * @param mapper
     *      Mapper instance
     */
    void setMapper(VideoGameMapper mapper) {
        this.mapper = mapper;
    }
}
