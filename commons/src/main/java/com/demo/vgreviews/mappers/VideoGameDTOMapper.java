/*
 * VideoGameDTOMapper.java
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
package com.demo.vgreviews.mappers;

import com.demo.vgreviews.domain.VideoGame;
import com.demo.vgreviews.dto.VideoGameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Definition of a mapper to transform domain layer objects to DTOs
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface VideoGameDTOMapper {

    /**
     * Maps a Domain layer {@link VideoGame} object into a DTO {@link VideoGameDTO} object
     *
     * @param game
     *      the domain layer object
     * @return
     *      the DTO object
     */
    @Mappings({
            @Mapping(source = "game.id", target = "id"),
            @Mapping(source = "game.name", target = "name"),
            @Mapping(source = "game.average", target = "rating")
    })
    VideoGameDTO map(VideoGame game);
}
