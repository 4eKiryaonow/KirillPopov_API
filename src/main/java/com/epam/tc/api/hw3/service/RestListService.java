package com.epam.tc.api.hw3.service;

import com.epam.tc.api.hw3.dto.BoardDTO;
import com.epam.tc.api.hw3.dto.ListDTO;
import com.epam.tc.api.hw3.utils.EndPoints;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class RestListService extends CommonService {

    public ListDTO createList(String listName, BoardDTO boardDTO) {

        return createListResponse(listName, boardDTO).as(ListDTO.class);
    }

    public Response createListResponse(String listName, BoardDTO boardDTO) {

        Map<String, String> params = new HashMap<>();
        params.put("name", listName);
        params.put("idBoard", boardDTO.getId());

        return postWithParams(EndPoints.LISTS, params);
    }

    public ListDTO getList(String listId) {

        return getNoParams(String.format(EndPoints.GET_LISTS, listId))
            .getBody().as(ListDTO.class);
    }
}
