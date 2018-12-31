	import java.util.ArrayList;
	import java.util.TreeSet;
	import java.util.HashMap;  //have to import HashMap this time

	/*
	Add a title to the bookstore's stock
	See if a bookstore has a book in stock (true/false)
	Remove a book from stock (for simplicity, if a book is not in stock, this method has no effect)
	Display all existing stock on the console output (System.out)
	Return a sorted set of unique titles that the bookstore has in stock (no duplicates, sort in the natural alphabetical order of String)

	Must use a map to store the count of books in stock and update these counts when books are added or removed
	*/
	
	public class Bookstore_count {
			private ArrayList <String> _alBooks; //titles of books and frequency stored in arrayList _alBooks
			private HashMap<String, Integer> count; //count takes the title as the String and the amount of the title as the Integer value
	         
			
			public Bookstore_count() {
				_alBooks = new ArrayList<String>();
				count  = new HashMap<>();
			}
			
			public void addTitle(String title) throws NullPointerException { 
				 if (title == null) {  //in case the string is null
					 throw new NullPointerException();
				 }
				 
				 else {
					 	if (count.containsKey(title)==false) {
					 		_alBooks.add(title);  
					 		count.put(title, 1); 			//if you add a book and it doesn't already exist, create it with quantity in stock = 1
					 	}
				
					 	else { //if containsKey(title)==true
					 		_alBooks.add(title);  
					 		Integer j = count.get(title); //set j to the value (quantity) associated with that title
					 		if (j==null) {
					 			throw new NullPointerException();
					 		}
					 		count.put(title, j + 1); //if you add a book (key of hashmap) and it already exists, add 1 to the key's value (quantity in stock)
					 	}
				 }
			}	 
			
			public boolean inStock(String title) { 
				return count.containsKey(title); //if it is in stock, count will have the key and containsKey will return true
			}
			
			public void removeBook(String title) { //removing a single book from stock is the assumption

				if (count.containsKey(title)) {
					_alBooks.remove(title);
					Integer j = count.get(title); 
						if (j > 1) {
							count.put(title, j - 1); //if you want to remove a book (key of hashmap) and it already exists, - 1 to the key's value (quantity in stock)
						}
						else if (j<=1) {
							count.remove(title);
						}
				}
			}
			
			public void displayStock() {
				/*for(String s : _alBooks) { //I am going to use the hashmap because it has the additional feature of displaying stock with quantity more compactly
					System.out.println(s); //However, this (which was used in Project1) still works too!
				}*/
				System.out.println(count);
			}
			
			public TreeSet<String> getSortedTitles() {
				TreeSet <String> ts = new TreeSet <String> ();
				ts.addAll(_alBooks);
				return ts;
			}
			
			
			public static void main(String[] args) {
				Bookstore_count bs = new Bookstore_count();
				bs.addTitle ("Huck Finn");
				bs.addTitle ("Huck Finn");
				bs.addTitle ("Huck Finn");
				bs.addTitle ("Huck Finn");
				bs.addTitle("Tom Sawyer");
				bs.removeBook("Huck Finn");
				bs.removeBook("Tom Sawyer");
				bs.removeBook("Tom Sawyer");
				System.out.println("In Stock Huck Finn?" + " " + bs.inStock("Huck Finn"));
				bs.displayStock();
				System.out.println(bs.getSortedTitles());
			}
	}

