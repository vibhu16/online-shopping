package com.vivek.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vivek.shoppingbackend.dao.CategoryDAO;
import com.vivek.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.vivek.shoppingbackend");
		// context.register(HibernateConfig.class);
		System.out.println("hello before");
		context.refresh();
		System.out.println("hello after");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Television");
	 * category.setDescription("Description for television");
	 * assertEquals("successfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * assertEquals("successfully fetched a single category from the table",
	 * "Laptop", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1); category.setName("TV	");
	 * assertEquals("successfully updated a single category from the table",
	 * true, categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("successfully deleted a single category from the table",
	 * true, categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * category = categoryDAO.get(1); assertEquals(
	 * "successfully fetched the list of categories from the table", 2,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();
		category.setName("Cell phone");
		category.setDescription("Description for television");
		category.setImageURL("CAT_1.png");
		assertEquals("successfully added a category inside the table", true,
				categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT_2.png");
		assertEquals("successfully added a category inside the table", true,
				categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("successfully updated a single category from the table",
				true, categoryDAO.update(category));

		// deleting the category
		assertEquals("successfully deleted a single category from the table",
				true, categoryDAO.delete(category));

		// fetching the list

		assertEquals(
				"successfully fetched the list of categories from the table",
				1, categoryDAO.list().size());

	}

}
