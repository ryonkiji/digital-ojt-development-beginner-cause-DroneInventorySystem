package com.digitalojt.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.digitalojt.web.consts.ErrorMessage;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * 在庫センター情報詳細（更新/削除）画面のバリデーションチェック インターフェース
 * 
 * @author Okuma
 */
@Constraint(validatedBy = UpdateCenterInfoFormValidatorImpl.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateCenterInfoFormValidator {

	String message() default ErrorMessage.ALL_FIELDS_EMPTY_ERROR_MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
