/*
 * VideoGame.java
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
package com.demo.vgreviews.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Represents a video game instance with all the behavior that it can have in a real world
 * reviews application.
 *
 * Some business logic and validations included for this example:
 * <ul>
 *     <li>Games can't be older than 2010</li>
 *     <li>Review comments cannot include some restricted words (trash, old, buggy).
 *          Unless the game rating is M.
 *     </li>
 *     <li>Review comments can't be longer than 255 characters</li>
 *     <li>Reviews' points go from 1 to 5</li>
 * </ul>
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
public class VideoGame {

    /**
     * Unique identifier of the video game
     */
    private final String id;

    /**
     * Name of the video game
     */
    private final String name;

    /**
     * Name of the company that made the game
     */
    private final String maker;

    /**
     * Year when the game was published
     */
    private final int year;

    /**
     * The ESRB rating
     */
    private final VideoGameRating esrb;

    /**
     * List of currently loaded video game reviews
     */
    private List<VideoGameReview> reviews;

    /**
     * Class constructor to initialize non mutable fields
     *
     * @param id
     *      Unique identifier of the video game
     * @param name
     *      Name of the video game
     * @param maker
     *      Name of the company that made the game
     * @param esrb
     *      The ESRB rating of the game
     * @param year
     *      Year when the game was published
     */
    public VideoGame(String id, String name, String maker, String esrb, int year) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.esrb = VideoGameRating.valueOf(esrb);
        this.year = year;
        this.reviews = new ArrayList<>();

        if (this.year < 2010) {
            throw new IllegalArgumentException("Game can't be older from 2010");
        }
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
    public VideoGameRating getEsrb() {
        return esrb;
    }

    /**
     * Getter for the <code>reviews</code> property
     *
     * @return
     *      The <code>reviews</code> property value
     */
    public List<VideoGameReview> getReviews() {
        return reviews;
    }

    /**
     * Adds a new review to the current video game
     *
     * @param points
     *      Amount of points given
     * @param comment
     *      Review comment
     * @param reviewDate
     *      When the review was given
     */
    public void addReview(int points, String comment, Date reviewDate) {
        List<String> errors;
        VideoGameReview review;
        Pattern p;
        Matcher m;

        p = Pattern.compile(".*\\btrash\\b.*|.*\\bold\\b.*|.*\\bbuggy\\b.*");
        m = p.matcher(comment.toLowerCase());

        errors = new ArrayList<>();
        if (points <= 0 || points > 5) {
            errors.add("Review points must go from 1 to 5");
        }
        if (comment.length() > 255) {
            errors.add("Comment can't be longer from 255 characters");
        }
        if (!this.esrb.equals(VideoGameRating.M) && m.matches()) {
            errors.add("Invalid words used in comment");
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.stream().collect(Collectors.joining(", ")));
        }

        review = new VideoGameReview(points, comment, reviewDate);
        this.reviews.add(review);
    }

    /**
     * Calculates and returns the average points based on all reviews
     *
     * @return
     *      The calculated average points
     */
    public double getAverage() {
        OptionalDouble average;

        average = this.reviews.stream().mapToDouble(VideoGameReview::getPoints).average();

        return average.isPresent() ? average.getAsDouble() : 0;
    }

    /**
     * Availabe ESRB ratings for a video game
     */
    enum VideoGameRating {
        EC,
        E,
        E10,
        T,
        M,
        RP,
        AO
    }
}