package com.ns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class DBBooks {
	TreeSet<Book> tset;
	
	public DBBooks() {
		tset=new TreeSet<Book>();
		Book b1=new Book(1, "abc", "xyz", 22.22);
		Book b2=new Book(2, "cba", "zyx", 23.23);
		Book b3=new Book(3, "bac", "yxz", 21.21);
	    tset.add(b1);
	    tset.add(b2);
	    tset.add(b3);
	}

	public List<Book> viewAll() {
		Iterator<Book> itr=tset.iterator();
		List<Book> list=new ArrayList<Book>();
		while(itr.hasNext()) {
			list.add(itr.next());
		}
		return list;
	}
	public Book viewByName(String name) {
		
		for (Book b : tset) {
			if(b.title.equals(name)) {
				return b;
			}
		}
		return null;
	}
	public void insert(Book b) {
		
		tset.add(b);
	}
	public boolean delete(int id) {
		Iterator<Book> itr=tset.iterator();
		while(itr.hasNext()) {
		  Book bTemp=itr.next();
			if(bTemp.bookId==id) {	
				itr.remove();
				return true;
			}
		}
		return false;
	}
	public boolean update(int id,double price) {
		Iterator<Book> itr=tset.iterator();
		while(itr.hasNext()) {
		  Book bTemp=itr.next();
			if(bTemp.bookId==id) {	
				String title=bTemp.title;
				String author=bTemp.author;
				itr.remove();
			   Book book=new Book(id,title,author,price);
				boolean b=tset.add(book);
				return b;
			}
		}
		return false;
	}
}
