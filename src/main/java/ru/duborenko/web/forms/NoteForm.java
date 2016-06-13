/**
 * 
 */
package ru.duborenko.web.forms;

import ru.duborenko.entity.Note;
import ru.duborenko.entity.NoteTagEntity;
import ru.duborenko.web.NoteTagEntityJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Форма заметки
 * 
 * @author MaxD
 *
 */
public class NoteForm implements Note<NoteTagEntity> {

	private String header;

	private String body;

	private NoteTagEntity tag;

	public String getHeader() {

		return header;
	}

	public String getBody() {

		return body;
	}

	@JsonDeserialize(using = NoteTagEntityJsonSerializer.class)
	public NoteTagEntity getTag() {

		return tag;
	}

	public void setHeader(String header) {
		this.header = header;

	}

	public void setBody(String body) {
		this.body = body;

	}

	public void setTag(NoteTagEntity tag) {
		this.tag = tag;

	}

}
