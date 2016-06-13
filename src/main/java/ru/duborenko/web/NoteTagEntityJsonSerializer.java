/**
 * 
 */
package ru.duborenko.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ru.duborenko.entity.NoteTag;
import ru.duborenko.entity.NoteTagEntity;
import ru.duborenko.service.NoteTagManager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author MaxD
 *
 */

public class NoteTagEntityJsonSerializer extends
		JsonDeserializer<NoteTagEntity> {
	/**
	 * 
	 */
	@Autowired
	@Qualifier("noteTagManager")
	private NoteTagManager noteTagManager;

	@Override
	public NoteTagEntity deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Long tagId = p.getValueAsLong();
		NoteTag noteTag = null;
		if (tagId != null && tagId != 0L) {

			noteTag = noteTagManager.getById(tagId);

		}
		return (NoteTagEntity) noteTag;
	}

}
