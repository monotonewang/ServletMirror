package com.demo.servletpath.upload.resources.dao;

import com.demo.servletpath.dbutils.customer.utils.DataSourceUtils;
import com.demo.servletpath.upload.resources.domain.Resource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by WangTest on 2016/12/25.
 */
public class ResourceDao {
    public int save(Resource resource) throws SQLException {
        String sql = "insert into resources values (null,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.update(sql, resource.getUuidName(), resource.getRealName(), resource.getSavePath(), resource.getUploadTime(), resource.getDescription());

    }

    public List<Resource> findAll() throws SQLException {
        String sql = "select * from resources";
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<>(Resource.class));
    }

    public Resource findById(String id) throws SQLException {
        String sql = "select * from resources where id=?";
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<>(Resource.class),id);
    }
}
