/*
 * VideoGameTests.java
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

package com.demo.vgreviews.domain;/*
 * com.demo.vgreviews.domain.VideoGameTests.java
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

import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class VideoGameTests {

    @Test
    public void testCreateGameOk() {
        VideoGame videoGame;
        String id = UUID.randomUUID().toString();
        String name = "Action Adventures";
        String maker = "Games developers inc";
        String esrb = "E";
        int year = 2019;

        videoGame = new VideoGame(id, name, maker, esrb, year);

        assertEquals(id, videoGame.getId());
        assertEquals(name, videoGame.getName());
        assertEquals(maker, videoGame.getMaker());
        assertEquals(esrb, videoGame.getEsrb().name());
        assertEquals(year, videoGame.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGameTooOld() {
        VideoGame videoGame;
        String id = UUID.randomUUID().toString();
        String name = "Action Adventures";
        String maker = "Games developers inc";
        String esrb = "E";
        int year = 2009;

        videoGame = new VideoGame(id, name, maker, esrb, year);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewInvalidComment() {
        VideoGame game;

        game = mockGame();

        game.addReview(1, "Game is trash", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewInvalidComment2() {
        VideoGame game;

        game = mockGame();

        game.addReview(1, "Game is old", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewInvalidComment3() {
        VideoGame game;

        game = mockGame();

        game.addReview(1, "buggy game", new Date());
    }

    @Test
    public void testAddReviewValidCommentMatureGame() {
        VideoGame game;

        game = mockGame2();

        game.addReview(1, "buggy game", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewLongComment() {
        VideoGame game;
        String longComment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sed consequat enim. Suspendisse rhoncus pellentesque tincidunt. Curabitur sem urna, efficitur vitae accumsan ac, bibendum a nisl. Aliquam pharetra tincidunt varius. Ut at tincidunt aeneana.";

        game = mockGame();

        game.addReview(1, longComment, new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewInvalidPoints() {
        VideoGame game;

        game = mockGame();

        game.addReview(6, "Great game", new Date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReviewInvalidPoints2() {
        VideoGame game;

        game = mockGame();

        game.addReview(0, "Bad game", new Date());
    }

    private VideoGame mockGame() {
        String id = UUID.randomUUID().toString();
        String name = "Action Adventures";
        String maker = "Games developers inc";
        String esrb = "E";
        int year = 2019;

        return new VideoGame(id, name, maker, esrb, year);
    }

    private VideoGame mockGame2() {
        String id = UUID.randomUUID().toString();
        String name = "Action Adventures";
        String maker = "Games developers inc";
        String esrb = "M";
        int year = 2019;

        return new VideoGame(id, name, maker, esrb, year);
    }
}
