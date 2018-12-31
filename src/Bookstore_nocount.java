	import java.util.ArrayList; //import ArrayList 
	import java.util.TreeSet; //import TreeSet

	public class Bookstore_nocount {
		private ArrayList <String> _alBooks; //each book in the store will be in this ArrayList

		public Bookstore_nocount() {
			_alBooks = new ArrayList<String>();
		}
		
		public void addTitle(String title) { //adds title of a book to _alBooks
			_alBooks.add(title);
		}
		
		public boolean inStock(String title) { //checks if book is present in _alBooks or not
			return _alBooks.contains(title);
		}
		
		public void removeBook(String title) { //if present, then remove a SINGLE book from stock is the assumption
			_alBooks.remove(title);
		}
		
		public void displayStock() { //display all strings in _alBooks
			for(String s : _alBooks) {
				System.out.println(s);
			}
		}
		
		public TreeSet<String> getSortedTitles() { //TreeSet will sort and remove duplicates when printed
			TreeSet <String> ts = new TreeSet <String> ();
			ts.addAll(_alBooks);
			return ts;
		}
		
		public static void main(String[] args) {
			Bookstore_nocount bs = new Bookstore_nocount();
			bs.addTitle ("Huck Finn");
			bs.addTitle ("Huck Finn");
			bs.addTitle ("Huck Finn");
			bs.addTitle("Tom Sawyer");
			bs.removeBook("Huck Finn");
			System.out.println("Is Huck Finn in stock?" + " " + bs.inStock("Huck Finn"));
			bs.displayStock();
			System.out.println(bs.getSortedTitles());
		}

	}
