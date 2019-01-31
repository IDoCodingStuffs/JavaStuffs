/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestLogic {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void plainGetRequestShouldReturnResponse() throws Exception {
        mockMvc.perform(get("/info/states/get/")).andDo(print()).andExpect(status().isOk())
                //Make sure plain get request returns a response with an array of states
                .andExpect(jsonPath("$.RestResponse.states").isArray());
    }

    @Test
    public void getRequestByAbbreviationShouldReturnState() throws Exception {
        String response = mockMvc.perform(get("/info/states/get/AL"))
                 .andDo(print())
                //Expect response status is ok
                 .andExpect(status().isOk())
                //Collect JSON response
                 .andReturn().getResponse().getContentAsString();

        //Compare returned JSON with expected result
        JSONAssert.assertEquals(response,
    "{\"RestResponse\":{\"messages\":\"State found matching code [AL].\"," +
                                " \"states\":[{\"id\":1, \"country\":\"USA\", \"name\":\"Alabama\"," +
                                " \"abbreviation\":\"AL\", \"area\":\"135767SKM\", \"largestCity\":\"Birmingham\"," +
                                " \"capital\":\"Montgomery\"}]}}", JSONCompareMode.STRICT);
    }

    @Test
    public void emptySearchShouldReturnResponse() throws Exception {
        mockMvc.perform(post("/info/states/get/")
                .contentType(MediaType.APPLICATION_JSON)
                //Empty search query
                .content("{\"search\":[]}"))
                .andDo(print())
                //Expect response status is ok
                .andExpect(status().isOk())
                //Make sure empty search request returns a response with an array of states
                .andExpect(jsonPath("$.RestResponse.states").isArray());
    }

    @Test
    public void invalidSearchFormatThrowsException() throws Exception {
        mockMvc.perform(post("/info/states/get/")
                .contentType(MediaType.APPLICATION_JSON)
                //Invalid search query
                .content("{\"query\":[]}"))
                //Make sure it is a bad request exception
                .andExpect(status().isBadRequest())
                //!TODO: Test for exception message as well
                .andDo(print());
    }

    @Test
    public void searchWithoutMatchesThrowsException() throws Exception {
        mockMvc.perform(post("/info/states/get/")
                .contentType(MediaType.APPLICATION_JSON)
                //Invalid search query
                .content("{\"search\":[\"Balabama\"]}"))
                //Make sure it is a not found exception
                .andExpect(status().isNotFound())
                //!TODO: Test for exception message as well
                .andDo(print());
    }

    @Test
    public void searchQueryInstanceWithSingleState() throws Exception {
        String response = mockMvc.perform(post("/info/states/get/")
                .contentType(MediaType.APPLICATION_JSON)
                //Invalid search query
                .content("{\"search\":[\"Alabama\"]}"))
                .andDo(print())
                //Expect response status is ok
                .andExpect(status().isOk())
                //Collect JSON response
                .andReturn().getResponse().getContentAsString();

        JSONAssert.assertEquals("[{\"id\":1, \"country\":\"USA\", \"name\":\"Alabama\", \"abbreviation\":\"AL\"," +
                " \"area\":\"135767SKM\", \"largestCity\":\"Birmingham\", \"capital\":\"Montgomery\"}]", response,
                JSONCompareMode.STRICT);
    }

    @Test
    public void searchQueryInstanceWithMultipleStates() throws Exception {
        String response = mockMvc.perform(post("/info/states/get/")
                .contentType(MediaType.APPLICATION_JSON)
                //Invalid search query
                .content("{\"search\":[\"Alabama\",\"California\",\"Idaho\"]}"))
                .andDo(print())
                //Expect response status is ok
                .andExpect(status().isOk())
                //Collect JSON response
                .andReturn().getResponse().getContentAsString();

        JSONAssert.assertEquals("[{\"id\":1, \"country\":\"USA\", \"name\":\"Alabama\"," +
                        " \"abbreviation\":\"AL\", \"area\":\"135767SKM\", \"largestCity\":\"Birmingham\", " +
                        "\"capital\":\"Montgomery\"}, {\"id\":5, \"country\":\"USA\", \"name\":\"California\", " +
                        "\"abbreviation\":\"CA\", \"area\":\"423967SKM\", \"largestCity\":\"Los Angeles\"," +
                        " \"capital\":\"Sacramento\"}, {\"id\":12, \"country\":\"USA\", \"name\":\"Idaho\", " +
                        "\"abbreviation\":\"ID\", \"area\":\"82643SKM\", \"largestCity\":\"Boise\", \"capital\":\"Boise\"}]",
                response,
                JSONCompareMode.STRICT);
    }
}
