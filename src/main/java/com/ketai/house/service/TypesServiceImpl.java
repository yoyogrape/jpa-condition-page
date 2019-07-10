package com.ketai.house.service;

import com.ketai.house.entity.Types;
import com.ketai.house.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author naruto
 * @date 2018/10/19 19:52
 */
@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesRepository typesRepository;

    @Override
    public List<Types> findAll() {
        return typesRepository.findAll();
    }
}
