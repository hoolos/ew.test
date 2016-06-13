/**
 * 
 */
package ru.duborenko.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.duborenko.entity.NoteEntity;
import ru.duborenko.entity.NoteTag;
import ru.duborenko.entity.NoteTagEntity;
import ru.duborenko.service.NoteManager;
import ru.duborenko.service.NoteTagManager;
import ru.duborenko.service.validation.NoteValidator;
import ru.duborenko.web.forms.NoteForm;

/**
 * @author MaxD
 *
 */
@Controller
@RequestMapping(value = "/json")
public class NoteJSONController {

	/**
	 * Менеджер тэгов
	 */
	@Autowired
	@Qualifier("noteTagManager")
	private NoteTagManager noteTagManager;
	/**
	 * Менеджер заметок
	 */
	@Autowired
	@Qualifier("noteManager")
	private NoteManager noteManager;

	/**
	 * Валидатор заметок
	 */
	@Autowired
	@Qualifier("noteValidator")
	private NoteValidator noteValidator;

	@Autowired
	@Qualifier("noteTagEditor")
	private NoteTagPropertyEditor noteTagEditor;

	@InitBinder("noteForm")
	public void initNoteFormBinder(WebDataBinder binder) {
		binder.addValidators(noteValidator);
		binder.registerCustomEditor(NoteTagEntity.class, noteTagEditor);

	}

	@RequestMapping(value = "/noteTags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<NoteTag> getNoteTageAsJSON(Model model) {
		List<NoteTag> tags = noteTagManager.getAllTags();
		return tags;
	}

	@RequestMapping(value = "/noteTags", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> postNoteTageAsJSON(
			@RequestBody @Validated NoteForm noteForm, BindingResult result,
			Model model) {
		Map<String, Object> reponseMap = new HashMap<String, Object>();
		if (result.hasErrors()) {

			reponseMap.put("error", "Ошибка");
		} else {

			NoteEntity noteEntity = new NoteEntity();
			noteEntity.setBody(noteForm.getBody());
			noteEntity.setHeader(noteForm.getHeader());
			noteEntity.setTag(noteForm.getTag());
			noteManager.save(noteEntity);
		}

		return reponseMap;
	}
}
