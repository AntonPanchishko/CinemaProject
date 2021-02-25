package com.dev.concert.service;

import com.dev.concert.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
