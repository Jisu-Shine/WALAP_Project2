package controller;

import model.BookModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private final String filePath;

    public FileController(String filePath) {
        this.filePath = filePath;
    }

    // Save books to JSON file
    public void saveBooksToFile(List<BookModel> books) {
        JSONArray jsonArray = new JSONArray();

        for (BookModel book : books) {
            JSONObject bookJson = new JSONObject();
            bookJson.put("title", book.getTitle());
            bookJson.put("author", book.getAuthor());
            bookJson.put("startDate", book.getStartDate());
            bookJson.put("lastReadDate", book.getLastReadDate());
            bookJson.put("pagesRead", book.getPagesRead());
            bookJson.put("totalPages", book.getTotalPages());
            bookJson.put("progress", book.getProgress());

            jsonArray.put(bookJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toString(4)); // Indentation of 4 spaces
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load books from JSON file
    public List<BookModel> loadBooksFromFile() {
        List<BookModel> books = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = new JSONArray(reader);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookJson = jsonArray.getJSONObject(i);
                String title = bookJson.getString("title");
                String author = bookJson.getString("author");
                String startDate = bookJson.getString("startDate");
                String lastReadDate = bookJson.getString("lastReadDate");
                int pagesRead = bookJson.getInt("pagesRead");
                int totalPages = bookJson.getInt("totalPages");
                double progress = bookJson.getDouble("progress");

                BookModel book = new BookModel(title, author, startDate, totalPages);
                book.setLastReadDate(lastReadDate);
                book.setPagesRead(pagesRead);
                book.setProgress(progress);

                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
