public class Book
{
    public String id;
    public String title;
    public String author;
    public String publishYear;
    public String status;

    public Book(String id, String title, String author, String pulishYear, String status)
    {
        this.id = id;
        this.title = title; 
        this.author = author;
        this.publishYear = pulishYear;
        this.status = status;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return  author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPublishYear() { return publishYear; }

    public void setPublishYear(String pulishYear) { this.publishYear = pulishYear; }
    
    @Override
    public String toString(){
        return "Book{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publishYear='" + publishYear + '\'' +
        ", status='" + status + '\'' +
        '}';
    }

        public String getStatus() {
        return status;
    }
        public void setStatus(String status) {
        this.status = status;
    }
}    
    




