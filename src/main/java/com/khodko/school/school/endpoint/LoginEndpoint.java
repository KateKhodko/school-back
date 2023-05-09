package com.khodko.school.school.endpoint;

import com.khodko.school.school.configuration.jwt.JwtTokenProvider;
import com.khodko.school.school.model.request.LoginRequest;
import com.khodko.school.school.model.response.LoginResponse;
import com.khodko.school.school.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

import static com.khodko.school.school.configuration.exception.ExceptionMessage.USER_NOT_FOUND_WITH_LOGIN;

@RestController
@RequiredArgsConstructor
@Tag(name = "Login", description = "Эндпоинт для входа и прочего (пинг сервера)")
public class LoginEndpoint {

	private final UserRepository userRepository;
	private final JwtTokenProvider jwtTokenProvider;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
		var expectedUser = Optional.ofNullable(userRepository.findByEmail(loginRequest.email()))
				.orElseThrow(
						() -> new EntityNotFoundException(USER_NOT_FOUND_WITH_LOGIN.formatted(loginRequest.email())));

		if (!JwtTokenProvider.passwordEncoder().matches(loginRequest.password(), expectedUser.getPassword())) {
			throw new PersistenceException("Passwords aren't equals. Retry");
		}

		var token = jwtTokenProvider.createToken(expectedUser.getEmail(),
				Collections.singletonList(expectedUser.getRole()));

		return ResponseEntity.ok(new LoginResponse(token));
	}
}
