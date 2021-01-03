/*
 * VideoGameDTO.java
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
package com.demo.vgreviews.dto;

/**
 * DTO used to transfer information to/from the UI. Contains only basic information about a video game
 * for listing.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
public class VideoGameDTO {

    /**
     * Unique identifier of the game
     */
    private String id;

    /**
     * Name of the game
     */
    private String name;

    /**
     * Rating of the game based on the average of points given on the reviews
     */
    private double rating;

    /**
     * Full class constructor
     *
     * @param id
     *      Unique identifier of the game
     * @param name
     *      Name of the game
     * @param rating
     *      Rating of the game based on the average of points given on the reviews
     */
    public VideoGameDTO(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
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
     * Getter for the <code>rating</code> property
     *
     * @return
     *      The <code>rating</code> property value
     */
    public double getRating() {
        return rating;
    }
}
