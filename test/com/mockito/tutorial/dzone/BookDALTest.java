package com.mockito.tutorial.dzone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.tutorial.dzone.dal.BookDAL;
import com.mockito.tutorial.dzone.models.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookDALTest {
	private static BookDAL mockedBookDAL;

	private static Book book1;
	private static Book book2;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeClass
	public static void setUp() throws Exception {

		// Create mock object of BookDAL
		mockedBookDAL = mock(BookDAL.class);

		// Create few instances of Book class.
		book1 = new Book("b1", "Compilers Principles",
				Arrays.asList("D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
				"Pearson Education Singapore Pte Ltd", 2008, 1009, "BOOK_IMAGE");

		book2 = new Book("b2", "Let Us C 13th Edition", Arrays.asList("Yashavant Kanetkar"), "BPB PUBLICATIONS", 2012,
				675, "BOOK_IMAGE");

	}
	
	@Test
	public void testEmptyBooks() throws Exception {
		// Stubbing the methods of mocked BookDAL with mocked data.
		when(mockedBookDAL.getAllBooks()).thenReturn(Collections.emptyList());
		
		List<Book> emptyBooks = mockedBookDAL.getAllBooks();
		assertNotNull(emptyBooks);
		assertEquals(Collections.emptyList(), emptyBooks);
	}

	@Test
	public void testGetAllBooks() throws Exception {
		// Stubbing the methods of mocked BookDAL with mocked data.
		when(mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

		List<Book> allBooks = mockedBookDAL.getAllBooks();
		assertEquals(2, allBooks.size());
		Book myBook = allBooks.get(0);
		assertEquals("b1", myBook.getIsbn());
		assertEquals("Compilers Principles", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
		assertEquals((Integer) 2008, myBook.getYearOfPublication());
		assertEquals((Integer) 1009, myBook.getNumberOfPages());
		assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
		assertEquals("BOOK_IMAGE", myBook.getImage());
	}
	
	@Test(expected = Exception.class)
	public void testEmptyBooks_exceptionThrown() throws Exception {
		// Stubbing the methods of mocked BookDAL with mocked data.
		when(mockedBookDAL.getBook("non_existing_id")).thenThrow(new Exception());
	}

	@Test
	public void testGetBook() {
		when(mockedBookDAL.getBook("b1")).thenReturn(book1);

		String isbn = "b1";

		Book myBook = mockedBookDAL.getBook(isbn);

		assertNotNull(myBook);
		assertEquals(isbn, myBook.getIsbn());
		assertEquals("Compilers Principles", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
		assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
		assertEquals((Integer) 2008, myBook.getYearOfPublication());
		assertEquals((Integer) 1009, myBook.getNumberOfPages());

	}

	@Test
	public void testAddBook() {
		when(mockedBookDAL.addBook(book1)).thenReturn(book1.getIsbn());

		String isbn = mockedBookDAL.addBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}

	@Test
	public void testUpdateBook() {
		when(mockedBookDAL.updateBook(book1)).thenReturn(book1.getIsbn());

		String isbn = mockedBookDAL.updateBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}
}
