package com.ns;

import java.util.List;
import java.util.Scanner;

public class Admin {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DBBooks db=new DBBooks();
		char b;
		do {
		System.out.println("press 1 to view all books");
		System.out.println("press 2 to search book by title");
		System.out.println("press 3 to insert a book");
		System.out.println("press 4 to delete book");
		System.out.println("press 5 to update the book");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			 List<Book> list=db.viewAll();
			 for (Book book : list) {
				System.out.println(book);
			}
			break;
	
		case 2:
			System.out.println("enter the title of the book");
			String name=sc.next();
			Book rb=db.viewByName(name);
			if(rb!=null) {
			System.out.println(rb);
			}else {
				System.out.println("there is no such book");
			}
			break;
			
		case 3:
			System.out.println("enter the book id");
			int iid=sc.nextInt();
			System.out.println("enter book name");
			String iname=sc.next();
			System.out.println("enter book price");
			double price=sc.nextDouble();
			System.out.println("enter author name");
			String author=sc.next();
			Book ib=new Book(iid,iname,author,price);
			 db.insert(ib);
			break;
        
		case 4:
			System.out.println("enter id of the book you want to delete");
			int id1=sc.nextInt();
			boolean bo=db.delete(id1);
			if(bo)
			System.out.println("book deleted");
			else
				System.out.println("no such book by this id");
			break;
			
		case 5:
			System.out.println("enter the id");
			int idu=sc.nextInt();
			System.out.println("enter the price");
			double p=sc.nextDouble();
			boolean bool=db.update(idu,p);
			if(bool) {
				System.out.println("book updated");
			}
			else {
				System.out.println("no book found by this id");
			}
			break;
		default:
			break;
		}
		System.out.println("press y for main menu");
		b=sc.next().charAt(0);
	}while(b=='Y'||b=='y');

	}

}
