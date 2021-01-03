/*
 * RestController.java
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Defines the different REST endpoints available to obtain information about games.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@RestController
public class GamesRestController {

    /**
     * Services to manage video games
     */
    @Autowired
    private IGamesServices gamesServices;

    /**
     * Lists the registered video games with basic information
     *
     * @return
     *      The list of registered video games with basic information
     */
    @GetMapping("/v1/games")
    public List<VideoGameDTO> getGames() {
        return gamesServices.getRegisteredGames();
    }
}