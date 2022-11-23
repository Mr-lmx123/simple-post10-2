package com.massz.service.impl;

import com.massz.dao.BarDao;
import com.massz.dao.PostDao;
import com.massz.model.Bar;
import com.massz.model.Post;
import com.massz.service.BarService;
import com.massz.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarServiceImpl implements BarService {

    @Autowired
    private BarDao barDao;

    @Override
    public List<Bar> getBarAll() {
        return barDao.getBarAll();
    }
}
