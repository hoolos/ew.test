/**
 * 
 */
package ru.duborenko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ru.duborenko.dao.NoteTagDao;
import ru.duborenko.entity.NoteTag;

/**
 * @author MaxD
 *
 */
@Component("noteTagManager")
public class NoteTagManagerImpl extends GeneralManageImpl<NoteTag, NoteTagDao>
		implements NoteTagManager {

	public List<NoteTag> getAllTags() {

		return getDao().getByNamedQuery("getAllTags");

	}

	@Override
	@Autowired
	@Qualifier("noteTagDao")
	public void setDao(NoteTagDao dao) {

		super.setDao(dao);
	}

}
