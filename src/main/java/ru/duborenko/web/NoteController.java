/**
 * 
 */
package ru.duborenko.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteEntity;
import ru.duborenko.entity.NoteTag;
import ru.duborenko.entity.NoteTagEntity;
import ru.duborenko.service.NoteManager;
import ru.duborenko.service.NoteTagManager;
import ru.duborenko.service.validation.NoteValidator;
import ru.duborenko.web.forms.NoteForm;
import ru.duborenko.web.forms.NoteSearchForm;

/**
 * Контроллер заметок
 * 
 * @author MaxD
 *
 */
@Controller
public class NoteController {

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
	/**
 * 
 */
	@Autowired
	@Qualifier("noteTagEditor")
	private NoteTagPropertyEditor noteTagEditor;

	/**
	 * Инициализация контроллера
	 * 
	 * @param binder
	 */
	@InitBinder("noteForm")
	public void initNoteFormBinder(WebDataBinder binder) {
		binder.addValidators(noteValidator);
		binder.registerCustomEditor(NoteTagEntity.class, noteTagEditor);

	}

	/**
	 * Инициализация контроллера
	 * 
	 * @param binder
	 */
	@InitBinder("noteSearchForm")
	public void initNoteSearchFormBinder(WebDataBinder binder) {
		binder.registerCustomEditor(NoteTagEntity.class, noteTagEditor);

	}

	/**
	 * Форма с заполнением заметокА
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public String notesForm(Model model) {
		List<NoteTag> tags = noteTagManager.getAllTags();

		model.addAttribute("noteTags", tags);
		return "notes";
	}

	/**
	 * 
	 * @param noteForm
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notes", method = RequestMethod.POST)
	public String noteSumbit(@ModelAttribute @Validated NoteForm noteForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {

			model.addAttribute("error", "Ошибка");
		} else {
			NoteEntity noteEntity = new NoteEntity();
			noteEntity.setBody(noteForm.getBody());
			noteEntity.setHeader(noteForm.getHeader());
			noteEntity.setTag(noteForm.getTag());
			noteManager.save(noteEntity);
		}
		return "notes";
	}

	@RequestMapping(value = "/allnotes", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String allNotes(@ModelAttribute NoteSearchForm noteSearchForm,
			BindingResult result, Model model) {
		List<NoteTag> tags = noteTagManager.getAllTags();
		List<Note<NoteTagEntity>> notes = noteManager.getNoteByTagAndHeader(
				noteSearchForm.getTag(), noteSearchForm.getNoteHeaderToFind());
		if (noteSearchForm.getTag() != null) {
			tags.remove(noteSearchForm.getTag());
			model.addAttribute("selectedTag", noteSearchForm.getTag());
		}
		if (noteSearchForm.getNoteHeaderToFind() != null) {

			model.addAttribute("searchHeaderValue",
					noteSearchForm.getNoteHeaderToFind());
		}
		model.addAttribute("notes", notes);
		model.addAttribute("noteTags", tags);

		return "allnotes";
	}
}
