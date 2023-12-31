package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.PasswordEditDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status)" +
    "values" +
    "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
    @AutoFill(value= OperationType.INSERT)
    void save(Employee employee);

    // 过于复杂的sql
    Page<Employee> pageQuery(EmployeePageQueryDTO dto);

    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    void updatePassword(PasswordEditDTO passwordEditDTO);

    @Select("select * from employee where id=#{id}")
    Employee getById(Integer id);


}
