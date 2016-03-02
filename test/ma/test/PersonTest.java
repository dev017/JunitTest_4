package ma.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ma.model.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {

	@Test
	public void getCodeById() {
		// GIVEN
		Person person = Mockito.mock(Person.class);
		final int CODE = 1564;

		// WHEN
		Mockito.when(person.getCodeById(CODE)).thenCallRealMethod();
		String code = person.getCodeById(CODE);

		// THEN
		assertNotNull(code); // Vérification du code != NULL
		Mockito.verify(person).getCodeById(CODE); // Vérifier que la méthode getCodeById est appelée
	}

	@Test
	public void getAgeByIdONE() {
		// GIVEN
		Person person = Mockito.mock(Person.class);
		final int ID = 1; // ID Obligatoirement doit être = 1

		// WHEN
		Mockito.when(person.getAgeById(ID)).thenCallRealMethod();
		final int AGE = person.getAgeById(ID);
		final int RESULT_IS_24 = 24;

		// THEN
		assertEquals(RESULT_IS_24, AGE);
		Mockito.verify(person).getAgeById(ID);
	}

	@Test
	public void getAgeByIdANOTHER() {
		// GIVEN
		Person person = Mockito.mock(Person.class);
		final int ID = 25; // ID Obligatoirement doit être != 1

		// WHEN
		Mockito.when(person.getAgeById(ID)).thenCallRealMethod();
		final int AGE = person.getAgeById(ID);
		final int RESULT_IS_30 = 30;

		// THEN
		assertEquals(RESULT_IS_30, AGE);
		Mockito.verify(person).getAgeById(ID);
	}

	@Test
	public void savePerson() {
		// GIVEN
		Person prs = Mockito.mock(Person.class);

		// WHEN
		Mockito.doCallRealMethod().when(prs).setId(Mockito.anyInt());
		Mockito.doCallRealMethod().when(prs).getId();
		Mockito.doCallRealMethod().when(prs).setName(Mockito.anyString());
		Mockito.doCallRealMethod().when(prs).getName();

		prs.setId(1);
		prs.setName("ABC");

		System.out.println(prs.getId() + " " + prs.getName());
		int isSaved = new Person().savePerson(prs);

		// THEN
		assertEquals(1, isSaved);
	}

}
