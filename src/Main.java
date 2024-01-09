import controller.BookController;
import view.BookView;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BookController bookController = new BookController();
        BookView bookView = new BookView(bookController);

        while (true){
            System.out.println("============menu============");
            System.out.println("\t 1. 도서 추가");
            System.out.println("\t 2. 도서 조회");
            System.out.println("\t 3. 도서 수정");
            System.out.println("\t 4. 도서 책갈피");
            System.out.println("\t 5. 도서 삭제");
            System.out.println("\t 6. 도서명 검색");
            System.out.println("\t 7. 진행률 정렬");
            System.out.println("============================");

            System.out.print("실행할 작업의 번호를 입력하시오 : ");
            int selected = s.nextInt();

            switch (selected) {
                case 0:
                    System.out.println("프로그램을 종료합니다. 좋은 하루 보내세요 :) ");
                    System.exit(0);
                    break;
                case 1:
                    bookView.createBook();
                    break;
                case 2:
                    bookView.printBookList();
                    break;
                case 3:
                    bookView.modifyBook();
                    break;
                case 4:
                    bookView.saveBookPage();
                    break;
                case 5:
                    bookView.deleteBook();
                    break;
                case 6:
                    bookView.searchBooks();
                    break;
                case 7:
                    bookView.sortByProgress();
                    break;
                default :
                    System.out.println("잘못 입력하였습니다.");

            }
            System.out.println();
        }

    }
}