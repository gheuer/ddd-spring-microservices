/*
 * com.demo.vgreviews.domain.VideoGame.java
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
package com.demo.vgreviews.outbound.data.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * JPA Entity used to persist and fetch video games information from a configured DB
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Entity
@Table(
        name = "VIDEO_GAME"
)
public class VideoGameEntity {

    /**
     * Unique identifier for the row
     */
    @Id
    @Column(name = "code", updatable = false)
    @SequenceGenerator(name = "VideoGameSeq", allocationSize = 1, sequenceName = "S_VIDEO_GAME")
    @GeneratedValue(generator = "VideoGameSeq")
    private Long code;

    /**
     * Human usable unique identifier
     */
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Name of the video game
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Name of the company that made the game
     */
    @Column(name = "maker", nullable = false)
    private String maker;

    /**
     * Year when the game was published
     */
    @Column(name = "year", nullable = false)
    private int year;

    /**
     * The ESRB rating
     */
    @Column(name = "esrb", nullable = false)
    private String esrb;

    /**
     * The list of reviews for the game
     */
    @OneToMany(mappedBy = "game")
    private Set<VideoGameReviewEntity> reviews;

    /**
     * Default class constructor
     */
    public VideoGameEntity() {
        super();
    }

    /**
     * Full class constructor
     *
     * @param code
     *      Unique identifier for the row
     * @param id
     *      Human usable unique identifier
     * @param name
     *      Name of the video game
     * @param maker
     *      Name of the company that made the game
     * @param year
     *      Year when the game was published
     * @param esrb
     *      The ESRB rating
     * @param reviews
     *      The list of reviews for the game
     */
    public VideoGameEntity(Long code, String id, String name, String maker, int year, String esrb,
                           Set<VideoGameReviewEntity> reviews) {
        this.code = code;
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.year = year;
        this.esrb = esrb;
        this.reviews = reviews;
    }

    /**
     * Getter for the <code>id</code> property
     *
     * @return
     *      The <code>id</code> property value
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for the <code>name</code> property
     *
     * @return
     *      The <code>name</code> property value
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the <code>maker</code> property
     *
     * @return
     *      The <code>maker</code> property value
     */
    public String getMaker() {
        return maker;
    }

    /**
     * Getter for the <code>year</code> property
     *
     * @return
     *      The <code>year</code> property value
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter for the <code>esrb</code> property
     *
     * @return
     *      The <code>esrb</code> property value
     */
    public String getEsrb() {
        return esrb;
    }

    /**
     * Getter for the <code>id</code> property
     *
     * @return
     *      The <code>id</code> property value
     */
    public Set<VideoGameReviewEntity> getReviews() {
        return reviews;
    }
}
