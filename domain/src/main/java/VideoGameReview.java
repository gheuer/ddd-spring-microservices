/*
 * VideoGameReview.java
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
import java.util.Date;

/**
 * Represents a review given to a video game.
 *
 * @author gheuer (gjhr1304@gmail.com)
 */
public class VideoGameReview {

    /**
     * Amount of points given to the game
     */
    private int points;

    /**
     * Written text review given to the game
     */
    private String review;

    /**
     * When the review was performed
     */
    private Date date;

    /**
     * Full class constructor
     *
     * @param points
     *      Amount of points given to the game
     * @param review
     *      Written text review given to the game
     * @param date
     *      When the review was performed
     */
    public VideoGameReview(int points, String review, Date date) {
        this.points = points;
        this.review = review;
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
     * Getter for the <code>review</code> property
     *
     * @return
     *      The <code>review</code> property value
     */
    public String getReview() {
        return review;
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
