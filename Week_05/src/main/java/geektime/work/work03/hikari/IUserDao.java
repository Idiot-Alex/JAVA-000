package geektime.work.work03.hikari;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承 JpaRepository 接口
 * 就可以直接使用里面的方法
 */
@Repository
public interface IUserDao extends JpaRepository<User,Long> {
}
