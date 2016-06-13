/**
 * 
 */
package ru.duborenko.service.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import ru.duborenko.entity.Note;

/**
 * @author MaxD
 *
 */
@Component("noteValidator")
public class NoteValidatorImpl implements NoteValidator {
	/**
	 * Ошибочный заголовок
	 */
	private final String INVALID_HEADER = "Ошибка";

	/**
	 * {@inheritDoc}
	 */
	public boolean supports(Class<?> clazz) {

		return Note.class.isAssignableFrom(clazz);

	}

	/**
	 * {@inheritDoc}
	 */
	public void validate(Object target, Errors errors) {
		Note<?> noteObject = (Note<?>) target;
		Object noteTagObject = noteObject.getTag();
		if (noteTagObject == null) {
			errors.reject("tag.is.null");

		}
		if (INVALID_HEADER.equals(noteObject.getHeader())) {
			errors.reject("header.is.invalid");
		}
	}
}
