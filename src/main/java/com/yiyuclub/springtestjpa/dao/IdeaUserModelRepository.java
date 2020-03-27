package com.yiyuclub.springtestjpa.dao;

import com.yiyuclub.springtestjpa.models.IdeaUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdeaUserModelRepository extends JpaRepository<IdeaUserModel, Integer>, JpaSpecificationExecutor<IdeaUserModel> {

    /**
     * 继承标准接口
     * And
     * Or
     * Between
     * LessThan
     * GreaterThan
     * IsNull
     * IsNotNull
     * NotNull
     * Like
     * NotLike
     * OrderBy
     * Not
     * In
     * NotIn
     */
    List<IdeaUserModel> findAllByIdIsLike(int id);

    /**
     * 自定义Query查询
     * 可用@Modifying标识为i需改操作
     * @Param("id") 可绑定:id
     */
    @Query(" from IdeaUserModel u where u.id =:id")
    List<IdeaUserModel> selectUserById(int id);
}