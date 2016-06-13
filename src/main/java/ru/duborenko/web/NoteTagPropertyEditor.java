/**
 * 
 */
package ru.duborenko.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ru.duborenko.service.NoteTagManager;

/**
 * @author MaxD
 *
 */
@Component("noteTagEditor")
public class NoteTagPropertyEditor extends PropertyEditorSupport {
	/**
	 * Менеджер тэгов
	 */
	@Autowired
	@Qualifier("noteTagManager")
	private NoteTagManager noteTagManager;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(noteTagManager.getById(new Long(text)));
	}
}
