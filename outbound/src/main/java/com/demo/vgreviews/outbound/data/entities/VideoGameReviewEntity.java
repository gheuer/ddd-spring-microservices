/*
 * com.demo.vgreviews.domain.VideoGameReview.java
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
import java.util.Date;

/**
 * JPA Entity used to persist and fetch video games reviews information from a configured DB
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
@Entity
@Table(
        name = "VIDEO_GAME_REVIEW"
)
public class VideoGameReviewEntity {

    /**
     * Unique identifier for the row
     */
    @Id
    @Column(name = "code", updatable = false)
    @SequenceGenerator(name = "VideoGameReviewSeq", allocationSize = 1, sequenceName = "S_VIDEO_GAME_REVIEW")
    @GeneratedValue(generator = "VideoGameReviewSeq")
    private Long code;

    /**
     * Amount of points given to the game
     */
    @Column(name = "points")
    private int points;

    /**
     * Written text review given to the game
     */
    @Column(name = "comment")
    private String comment;

    /**
     * When the review was performed
     */
    @Column(name = "review_date")
    private Date date;

    /**
     * The reviewed video game
     */
    @ManyToOne
    private VideoGameEntity game;

    /**
     * Full class constructor
     * @param points
     *      Amount of points given to the game
     * @param comment
     *      Written text review given to the game
     * @param date
     *      When the review was performed
     */
    public VideoGameReviewEntity(int points, String comment, Date date) {
        this.points = points;
        this.comment = comment;
        this.date = date;
    }

    /**
     * Getter for the <code>points</code> property
     *
     * @return
     *      The <code>points</code> property value
     */
    public int getPoints() {
        return points;
    }

    /**
     * Getter for the <code>comment</code> property
     *
     * @return
     *      The <code>comment</code> property value
     */
    public String getComment() {
        return comment;
    }

    /**
     * Getter for the <code>date</code> property
     *
     * @return
     *      The <code>date</code> property value
     */
    public Date getDate() {
        return date;
    }
}
