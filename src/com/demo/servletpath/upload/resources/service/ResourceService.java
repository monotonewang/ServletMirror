package com.demo.servletpath.upload.resources.service;

import com.demo.servletpath.upload.resources.dao.ResourceDao;
import com.demo.servletpath.upload.resources.domain.Resource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by WangTest on 2016/12/25.
 */
public class ResourceService {
    ResourceDao resourceDao = new ResourceDao();

    public int save(Resource resource) throws SQLException {
        resource.setUploadTime(new Timestamp(new Date().getTime()));
        return resourceDao.save(resource);
    }

    public List<Resource> findAll() throws SQLException {
        return new ResourceDao().findAll();
    }

    public Resource findById(String id) throws SQLException {
        return resourceDao.findById(id);
    }
}
