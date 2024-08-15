package org.example.expensetracker.mapper;

import org.example.expensetracker.dto.TokenUser;
import org.example.expensetracker.model.User;
import org.example.expensetracker.request.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User fromRegisterRequest(RegisterRequest registerRequest);

    TokenUser tokenUserFromUser(User user);
}
