/**
 * 
 */
package ru.duborenko.test.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ru.duborenko.entity.NoteTag;
import ru.duborenko.entity.NoteTagEntity;
import ru.duborenko.service.NoteTagManager;

/**
 * @author MaxDS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/applicationContext-web-test.xml")
public class ControllerWebTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	@Qualifier("noteTagManager")
	private NoteTagManager noteTagManager;

	private List<NoteTag> notes;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	@Test
	public void getAccount() throws Exception {
		Assert.assertTrue(true);
		NoteTagEntity noteTag = new NoteTagEntity();
		noteTag.setName("Test1");
		noteTag.setId(0L);
		noteTag.setDescription("TestDescp1");
		notes = new ArrayList<NoteTag>();
		notes.add(noteTag);
		Mockito.when(noteTagManager.getAllTags()).thenReturn(notes);
		mockMvc.perform(MockMvcRequestBuilders.get("/allnotes"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.model().attributeExists("notes",
								"noteTags"))
				.andExpect(
						MockMvcResultMatchers.model().attribute("noteTags",
								notes));
	}
}
