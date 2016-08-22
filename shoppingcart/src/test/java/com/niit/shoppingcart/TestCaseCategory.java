package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

 @Autowired
 CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
	categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	category= (Category) context.getBean("category");
	}
@Test
public void deleteCategoryTest(){
	category.setId("cg_1");
	boolean flag =categoryDAO.delete(category);
	assertEquals("deleteCategoryTest",flag,true);
	
}
@Test
public void addCategoryTest()

{
	category.setId("CAT_002");
	category.setName("ELECTRONIC");
	category.setDescription("this is new iphone");
	
	assertEquals("addCategoryTest",categoryDAO.save(category),true);
	
}
@Test
public void listCategoryTest(){
	assertEquals("listCategoryTest",categoryDAO.list().size(),1);
}
@Test
public void updateCategoryTestCase(){
	category.setId("CAT_002");
	category.setName("GAD");
	category.setDescription("this is new iphone");
	assertEquals("updateCategoryTestCase",categoryDAO.update(category),true);
	
}
@Test
public void getCategoryTestCase(){
category=categoryDAO.get("CAT_002");
assertEquals("getCategoryTestCase",category.getName(),"GAD");
}
}
