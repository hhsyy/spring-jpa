package com.yiyuclub.springtestjpa.service;

import com.yiyuclub.springtestjpa.dao.IdeaUserModelRepository;
import com.yiyuclub.springtestjpa.models.IdeaUserModel;
import net.bytebuddy.TypeCache;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IdeaUserModelRepository userModelRepository;

    /**
     * 自定义查询查询
     * @return
     */
    public   List<IdeaUserModel> getUserByDiy() {
        List<IdeaUserModel> allByIdIsLike = userModelRepository.findAllByIdIsLike(10);

        List<IdeaUserModel> allByIdIsLike1 = userModelRepository.selectUserById(5);

        return allByIdIsLike1;
    }


    /**
     * Example查询
     * @return
     */
    public   List<IdeaUserModel> getUserByExample(){
        //方式1 单条件查询
        IdeaUserModel ideaUserModel1 = new IdeaUserModel();
        ideaUserModel1.setRoleId(1);
        Example<IdeaUserModel> example1 = Example.of(ideaUserModel1);

        //方式2 ExampleMatcher对日期的查询很不友好，不支持动态查询
        IdeaUserModel ideaUserModel2 = new IdeaUserModel();
        ideaUserModel2.setId(1);
        //contains包含1；starting前包含1.ending后包含1；以上皆区分大小写
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("id",ExampleMatcher.GenericPropertyMatchers.contains());

        Example example2 = Example.of(ideaUserModel2,exampleMatcher);

//        List<IdeaUserModel> all = userModelRepository.findAll(example1);
        List<IdeaUserModel> all = userModelRepository.findAll(example2);

        return all;
    }

    /**
     * Pageable分页查询
     * @return
     */
    public Page<IdeaUserModel> getUserPageable(){
        Pageable pageable = PageRequest.of(1,10);
        Page<IdeaUserModel> all = userModelRepository.findAll(pageable);
        return all;
    }

    /**
     *Specification条件查询
     */
    public  List<IdeaUserModel> getUserBySpecification(){
        Specification<IdeaUserModel> specification = new Specification<IdeaUserModel>() {
            @Override
            public Predicate toPredicate(Root<IdeaUserModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> roleId = root.get("roleId");
                Path<Object> phone = root.get("phone");
                Predicate predicate = criteriaBuilder.equal(roleId, "1");
                Predicate like = criteriaBuilder.like(phone.as(String.class), "2%");
                Predicate and = criteriaBuilder.and(predicate, like);
                return and;
            }
        };
        List<IdeaUserModel> all = userModelRepository.findAll(specification);
        return all;
    }

    /**
     * 排序
     * @return
     */
    public  List<IdeaUserModel>  getUserBySoft(){
        List<IdeaUserModel> all = userModelRepository.findAll(Sort.by(Sort.Direction.DESC,"roleId"));
        return all;
    }

    /**
     * 基本查询
     * @return
     */
    public  List<IdeaUserModel>  getUserList(){
        List<IdeaUserModel> all = userModelRepository.findAll();
        return all;
    }
}
