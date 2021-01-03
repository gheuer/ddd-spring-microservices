/*
 * VideoGameMapper.java
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
package com.demo.vgreviews.outbound.data.mappers;

import com.demo.vgreviews.domain.VideoGame;
import com.demo.vgreviews.domain.VideoGameReview;
import com.demo.vgreviews.outbound.data.entities.VideoGameEntity;
import com.demo.vgreviews.outbound.data.entities.VideoGameReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper of Video game entities to domain business beans using mapstruct.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Mapper(componentModel = "spring")
public interface VideoGameMapper {

    /**
     * Maps a {@link VideoGameEntity} object to a {@link VideoGame} object by setting the information where it goes.
     *
     * @param entity
     *      the persistence layer object
     * @return
     *      the domain model object
     */
    @Mappings({
        @Mapping(target = "id", source = "entity.id"),
        @Mapping(target = "name", source = "entity.name"),
        @Mapping(target = "maker", source = "entity.maker"),
        @Mapping(target = "year", source = "entity.year"),
        @Mapping(target = "esrb", source = "entity.esrb"),
        @Mapping(target = "reviews", expression = "java(mapReviews(entity.getReviews()))")
    })
    VideoGame map(VideoGameEntity entity);

    /**
     * Maps a list of {@link VideoGameReviewEntity} object to a list of {@link VideoGameReview} objects by setting the
     * information where it goes.
     *
     * @param reviews
     *      the persistence layer object's list
     * @return
     *      the domain model object's list
     */
    default List<VideoGameReview> mapReviews(Set<VideoGameReviewEntity> reviews) {
        return reviews
                .stream()
                .map(e -> new VideoGameReview(e.getPoints(), e.getComment(), e.getDate()))
                .collect(Collectors.toList());
    }
}
