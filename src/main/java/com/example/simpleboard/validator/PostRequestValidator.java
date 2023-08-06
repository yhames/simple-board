package com.example.simpleboard.validator;

import com.example.simpleboard.request.PostRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class PostRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PostRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boardId", "empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "empty");
    }
}
