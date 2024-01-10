package org.example.view;

import org.example.controller.BookController;
import org.example.model.BookModel;

import java.util.*;

public class BookView {
    Scanner s;
    BookController bookController;

    public BookView(BookController bookController){
        this.s = new Scanner(System.in);
        this.bookController = bookController;
    }

    //도서 등록
    public void createBook(){
        s = new Scanner(System.in);
        System.out.println();
        System.out.print("도서명 : ");
        String title = s.nextLine();
        System.out.print("작가명 : ");
        String author= s.nextLine();
        System.out.print("독서 시작일 (yyyy.MM.dd 형식) : ");
        String startDate = s.nextLine();
        System.out.print("전체 페이지 수 : ");
        int totalPages = s.nextInt();

        bookController.addBook(title, author, startDate, totalPages);

    }
    final int COLUMN_WIDTH = 15;

    //도서 목록
    public void printBookList() {
        List<BookModel> books = bookController.displayBooks();

        if (books.isEmpty()) {
            System.out.println("데이터가 없습니다!");
        } else {
            System.out.println("=========================================도서 목록========================================");
            System.out.printf( "%-8s %-7s %-11s %-12s %-9s %-9s %-11s %-6s\n", "도서번호", "도서명", "작가명", "시작일", "종료일", "읽은 쪽 수", "전체 쪽 수", "진행률");
            System.out.println("========================================================================================");
            for (BookModel book : books) {
                System.out.printf("   %-5s  %-10s  %-7s  %-13s  %-15s  %-9s  %-8s  %-6s\n",
                        books.indexOf(book) + 1,
                        book.getTitle(),
                        book.getAuthor(),
                        book.getStartDate(),
                        book.getLastReadDate(),
                        book.getPagesRead(),
                        book.getTotalPages(),
                        book.getProgress());
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println();
        }
    }
    //도서 수정
    public void modifyBook(){
        s = new Scanner(System.in);
        System.out.print("수정할 도서명 : ");
        String title = s.nextLine();
        while(bookController.findBookByTitle(title) == null){
            System.out.println("해당 도서를 찾을 수 없습니다.\n 도서명을 다시 입력해주세요 : ");
            title = s.nextLine();
        }

        System.out.println("---------도서 정보 업데이트---------");
        System.out.print("도서명 : ");
        String title_m = s.nextLine();
        System.out.print("작가명 : ");
        String author= s.nextLine();
        System.out.print("독서 시작일 (yyyy.MM.dd 형식) : ");
        String startDate = s.nextLine();
        System.out.print("전체 페이지 수 : ");
        String totalPages= s.nextLine();

        bookController.updateBook(title, title_m, author, startDate, Integer.parseInt(totalPages));
    }

    //도서 책갈피
    public void saveBookPage(){
        s = new Scanner(System.in);
        System.out.print("책갈피 설정할 도서명 : ");
        String title = s.nextLine();
        while(bookController.findBookByTitle(title) == null){
            System.out.println("해당 도서를 찾을 수 없습니다.\n 도서명을 다시 입력해주세요 : ");
            title = s.nextLine();
        }

        System.out.println("---------책갈피 설정---------");
        System.out.print("마지막으로 읽은 날짜 (yyyy.MM.dd 형식) : ");
        String lastReadDate = s.nextLine();
        System.out.print("읽은 페이지 수 : ");
        String pagesRead= s.nextLine();

        bookController.saveBookPage(title, lastReadDate, Integer.parseInt(pagesRead));
    }

    //도서 삭제
    public void deleteBook(){
        s = new Scanner(System.in);
        System.out.print("삭제할 도서명 : ");
        String title = s.nextLine();
        bookController.deleteBook(title);
    }

    //도서명 검색
    public void searchBooks(){
        s = new Scanner(System.in);
        System.out.print("찾으려는 도서 단어 : ");
        String title = s.nextLine();
        List<BookModel> books = bookController.searchBook(title);

        if (books.isEmpty()){
            System.out.println("검색 결과가 없습니다.");
        }
        else {
            System.out.println("===========================검색 결과==========================");
            System.out.printf( "%-3s %-7s %-3s %-8s %-8s %-3s %-3s %-3s\n", "도서번호", "도서명", "작가명", "시작일", "종료일", "읽은 페이지수", "전체 페이지 수", "진행률");
            System.out.println("============================================================");
            for (BookModel book : books) {
                System.out.printf("%-3s %-7s %-3s %-8s %-8s %-3s %-3s %-3s\n",
                        books.indexOf(book) + 1,
                        book.getTitle(),
                        book.getAuthor(),
                        book.getStartDate(),
                        book.getLastReadDate(),
                        book.getPagesRead(),
                        book.getTotalPages(),
                        book.getProgress());
            }
            System.out.println("----------------------------------------------------------");
            System.out.println();
        }

    }
    //진행률 정렬
    public void sortByProgress(){
        ArrayList<BookModel> books =  bookController.sortByProgress();

        if (books.isEmpty()) {
            System.out.println("데이터가 없습니다.\n");
        } else {
            System.out.println("===========================진행률 정렬==========================");
            System.out.printf( "%-3s %-7s %-3s %-8s %-8s %-3s %-3s %-3s\n", "도서번호", "도서명", "작가명", "시작일", "종료일", "읽은 페이지수", "전체 페이지 수", "진행률");
            System.out.println("============================================================");
            for (BookModel book : books) {
                System.out.printf("%-3s %-7s %-3s %-8s %-8s %-3s %-3s %-3s\n",
                        books.indexOf(book) + 1,
                        book.getTitle(),
                        book.getAuthor(),
                        book.getStartDate(),
                        book.getLastReadDate(),
                        book.getPagesRead(),
                        book.getTotalPages(),
                        book.getProgress());
            }
            System.out.println("----------------------------------------------------------");
            System.out.println();
        }
    }
}


