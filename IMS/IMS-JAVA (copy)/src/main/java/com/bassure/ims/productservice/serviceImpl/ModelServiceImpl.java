package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Model> getModels() {
        return modelRepository.findAll();
    }
}
