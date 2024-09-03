package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.repositories.GameListRepository;




@Service
public class GameListService {
    
    @Autowired
    private GameListRepository repository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = repository.findAll();
       return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
