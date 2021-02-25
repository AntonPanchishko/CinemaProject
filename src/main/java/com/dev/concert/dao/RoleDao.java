package com.dev.concert.dao;

import com.dev.concert.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String roleName);
}
