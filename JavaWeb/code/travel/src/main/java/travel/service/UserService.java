package travel.service;

import travel.domain.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
