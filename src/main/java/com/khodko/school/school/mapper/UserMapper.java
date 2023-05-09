package com.khodko.school.school.mapper;

import com.khodko.school.school.configuration.jwt.JwtTokenProvider;
import com.khodko.school.school.model.User;
import com.khodko.school.school.model.request.CreateUserRequest;
import com.khodko.school.school.model.request.UpdateUserRequest;
import com.khodko.school.school.model.response.UserResponse;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

	@BeforeMapping
	default void mapPassword(CreateUserRequest request) {
		Optional.ofNullable(request.getPassword())
				.ifPresent(password -> {
					var encodedPassword = JwtTokenProvider.passwordEncoder().encode(password);
					request.setPassword(encodedPassword);
				});
	}

	User convert(CreateUserRequest request);
	User convert(UpdateUserRequest request);
	UserResponse convert(User user);
	List<UserResponse> convert(List<User> users);

	void update(@MappingTarget User updatedUser, User userFromRequest);
}
