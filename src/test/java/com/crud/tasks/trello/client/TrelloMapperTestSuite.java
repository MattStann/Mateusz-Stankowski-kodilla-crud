package com.crud.tasks.trello.client;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void trelloMapToBoardsTest() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "name 1", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoardDtoMapper = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(1, trelloBoardDtoMapper.size());
    }

    @Test
    public void trelloMapToBoardsDtoTest() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("1", " name 1", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardMapper = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(1, trelloBoardMapper.size());
    }

    @Test
    public void trelloMapToListTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", " name1", true);
        List<TrelloListDto> trelloListDtoArrayList = new ArrayList<>();
        trelloListDtoArrayList.add(trelloListDto);

        //When
        List<TrelloList> trelloListDtoMapper = trelloMapper.mapToList(trelloListDtoArrayList);

        //Then
        assertEquals(1, trelloListDtoMapper.size());
    }

    @Test
    public void trelloMapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("1", "name 1", true);
        List<TrelloList> trelloListArrayList = new ArrayList<>();
        trelloListArrayList.add(trelloList);

        //When
        List<TrelloListDto> trelloListMapper = trelloMapper.mapToListDto(trelloListArrayList);

        //Then
        assertEquals(1, trelloListMapper.size());
    }

    @Test
    public void trelloMapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name 1", "desc 1", "first", "1");

        //When
        TrelloCard trelloCardDtoMapper = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("desc 1", trelloCardDtoMapper.getDescription());
    }

    @Test
    public void trelloMapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name 1", "desc 1", "first", "1");

        //When
        TrelloCardDto trelloCardMapper = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("name 1", trelloCardMapper.getName());
    }
}
