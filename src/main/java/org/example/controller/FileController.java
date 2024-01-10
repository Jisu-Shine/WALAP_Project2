package org.example.controller;

import org.example.model.BookModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
    public void saveBooksToJson(List<BookModel> books) {
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

            jsonArray.add(bookJson);  // Use add method instead of put
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());  // Use toJSONString without indentation
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load books from JSON file
    public List<BookModel> loadBooksFromFile() {
        List<BookModel> books = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(reader);

            for (Object obj : jsonArray) {
                JSONObject bookJson = (JSONObject) obj;
                String title = (String) bookJson.get("title");
                String author = (String) bookJson.get("author");
                String startDate = (String) bookJson.get("startDate");
                String lastReadDate = (String) bookJson.get("lastReadDate");

                int pagesRead = Integer.parseInt(String.valueOf(bookJson.get("pagesRead")));
                int totalPages = Integer.parseInt(String.valueOf(bookJson.get("totalPages")));
                double progress = Double.parseDouble(String.valueOf(bookJson.get("progress")));

                BookModel book = new BookModel(title, author, startDate, totalPages);
                book.setLastReadDate(lastReadDate);
                book.setPagesRead(pagesRead);
                book.setProgress(progress);

                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        } catch (ClassCastException e) {
            System.err.println("ClassCastException: " + e.getMessage());
        }
        return books;
    }

}
