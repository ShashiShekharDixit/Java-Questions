public class Book {
    private final int id;
    private final String title;
    private final String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;              
        if (obj == null || getClass() != obj.getClass()) return false; 
        Book other = (Book) obj;
        return this.id == other.id;                
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "'}";
    }
    public static void main(String[] args) {
        Book book1 = new Book(1, "Maths", "R.D.Sharma");
        Book book2 = new Book(2, "Chemistry", "R.S.Aggrawal"); 
        Book book3 = new Book(3, "Biology", "Priyanka");
        System.out.println("Book1: " + book1);
        System.out.println("Book2: " + book2);
        System.out.println("Book3: " + book3);
        System.out.println("book1 equals book2? " + book1.equals(book2)); 
        System.out.println("book1 equals book3? " + book1.equals(book3)); 
        System.out.println("book1.hashCode(): " + book1.hashCode());
        System.out.println("book2.hashCode(): " + book2.hashCode());
        System.out.println("book3.hashCode(): " + book3.hashCode());
    }
}