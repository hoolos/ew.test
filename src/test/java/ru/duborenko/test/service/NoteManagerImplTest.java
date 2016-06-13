/**
 * 
 */
package ru.duborenko.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTag;
import ru.duborenko.service.NoteManager;
import ru.duborenko.service.NoteTagManager;

/**
 * @author MaxD
 *
 */

public class NoteManagerImplTest extends AbstractServiceTestCase {

	@Autowired
	@Qualifier("noteManager")
	private NoteManager noteManager;

	@Autowired
	@Qualifier("noteTagManager")
	private NoteTagManager noteTagManager;

	@Test
	public void testGetById() {

		Note<NoteTag> note = (Note<NoteTag>) noteManager.getById(1L);
		Assert.assertNotNull(note);
		Assert.assertEquals("Заметка 1", note.getBody());
		NoteTag noteTag = note.getTag();
		Assert.assertNotNull(noteTag);
		Assert.assertEquals("Java", noteTag.getName());

		List<NoteTag> tags = noteTagManager.getAllTags();
		Assert.assertNotNull(tags);

	}
}
