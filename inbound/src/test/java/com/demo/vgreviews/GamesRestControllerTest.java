/*
 * GamesRestControllerTest.java
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
package com.demo.vgreviews;

import com.demo.vgreviews.dto.VideoGameDTO;
import com.demo.vgreviews.spec.IGamesServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GamesRestControllerTest {

    @Mock
    private IGamesServices gamesServices;

    @InjectMocks
    private GamesRestController restController;

    @Test
    public void testGetGames() {
        List<VideoGameDTO> expected;

        when(gamesServices.getRegisteredGames()).thenReturn(this.mockGames());

        expected = restController.getGames();

        assertFalse(expected.isEmpty());
    }

    private List<VideoGameDTO> mockGames() {
        List<VideoGameDTO> games;

        games = new ArrayList<>();
        games.add(new VideoGameDTO("1", "Test 1", 1));
        games.add(new VideoGameDTO("2", "Test 2", 2));

        return games;
    }
}
