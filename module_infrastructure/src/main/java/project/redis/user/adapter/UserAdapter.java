package project.redis.user.adapter;

import project.redis.user.User;

public interface UserAdapter {
    User find(Long userId);
}
