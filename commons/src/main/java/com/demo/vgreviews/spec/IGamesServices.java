/*
 * IGamesServices.java
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
package com.demo.vgreviews.spec;

import com.demo.vgreviews.dto.VideoGameDTO;

import java.util.List;

/**
 * Interface (adapter) used to access video games services like listing them.
 *
 * @author Guillermo Heuer (gjhr1304@gmail.com)
 */
public interface IGamesServices {

    /**
     * Obtains the list of video games registered with its based average rating.
     *
     * @return
     *      List of {@link VideoGameDTO} instances
     */
    List<VideoGameDTO> getRegisteredGames();
}
