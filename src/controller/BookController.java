package controller;

import model.BookModel;

import java.util.*;

public class BookController {
    private final List<BookModel> book;

    public BookController() {
        this.book = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(String title, String author, String startDate, int totalPages) {
        BookModel newBook = new BookModel(title, author, startDate, totalPages);
        book.add(newBook);
        System.out.println("새로운 도서가 추가되었습니다.");
    }

    // 도서 목록 보기
    public List<BookModel> displayBooks() {
        return book;
    }

    // 도서 수정하기
    public void updateBook(String title, String title_m, String author, String startDate, int totalPages) {
        BookModel book = findBookByTitle(title);

        if (title_m != null && !title_m.isEmpty()) {
            book.setTitle(title_m);
        }
        if (author != null && !author.isEmpty()) {
            book.setAuthor(author);
        }
        if (startDate != null && !startDate.isEmpty()) {
            book.setStartDate(startDate);
        }
        if (totalPages != '\0') {
            book.setTotalPages(totalPages);
        }
        System.out.println("도서가 성공적으로 업데이트되었습니다:)");
    }

    //도서명으로 도서 찾기
    public BookModel findBookByTitle(String title) {
        return book.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    //도서 책갈피
    public void saveBookPage(String title, String lastReadDate, int pagesRead) {
        BookModel book = findBookByTitle(title);

        if (lastReadDate != null && !lastReadDate.isEmpty()) {
            book.setLastReadDate(lastReadDate);
        }
        if (pagesRead != '\0') {
            book.setPagesRead(pagesRead);
        }
        book.setProgress(pagesRead/(float)book.getTotalPages()*100);
        System.out.println("책갈피를 설정하였습니다:-)");
    }


    // 도서 삭제하기
    public void deleteBook(String title) {
        book.removeIf(book -> book.getTitle().equals(title));
        System.out.println("도서가 삭제되었습니다.");
    }

    // 도서 검색하기 (예시: 제목으로 도서 검색)
    public List<BookModel> searchBook(String searchString) {
        List<BookModel> matchingBooks = new ArrayList<>();

        for (BookModel b : book) {
            if (b.getTitle().contains(searchString)) {
                matchingBooks.add(b);
            }
        }
        return matchingBooks;
    }

    // 진행률 정렬하기 (예시: 진행률에 따라 오름차순 정렬)
    public  ArrayList<BookModel> sortByProgress() {
        ArrayList<BookModel> sortedBooks = new ArrayList<>(book);
        sortedBooks.sort(Comparator.comparingDouble(BookModel::getProgress));
        return sortedBooks;
    }

}
