/*
 * VideoGamesDBDaoTest.java
 *
 * Copyright 2021
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
import com.demo.vgreviews.outbound.data.mappers.VideoGameMapperImpl;
import com.demo.vgreviews.outbound.data.repositories.VideoGamesRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class VideoGamesDBDaoTest {

    private VideoGamesRepository repository;

    private VideoGamesDBDao dao;

    @Before
    public void setup() {
        VideoGameMapper mapper;

        mapper = new VideoGameMapperImpl();
        repository = Mockito.mock(VideoGamesRepository.class);
        dao = new VideoGamesDBDao();

        dao.setRepository(repository);
        dao.setMapper(mapper);
    }

    @Test
    public void testRetrieveVideoGames() {
        List<VideoGame> games;

        when(repository.findAll()).thenReturn(mockEntities());

        games = dao.findRegisteredGames();

        assertEquals(2, games.size());
    }

    private List<VideoGameEntity> mockEntities() {
        List<VideoGameEntity> games;
        VideoGameEntity entity1;
        VideoGameEntity entity2;

        games = new ArrayList<>();
        games.add(new VideoGameEntity(1L, "Test 1", "Test 1", "Test 1", 2020, "M", new HashSet<>()));
        games.add(new VideoGameEntity(2L, "Test 2", "Test 2", "Test 2", 2020, "M", new HashSet<>()));

        return games;
    }
}
