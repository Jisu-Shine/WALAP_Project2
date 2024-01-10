package org.example.model;

public class BookModel {
    private String title;
    private String author;
    private String startDate;
    private String lastReadDate;
    private int pagesRead;
    private int totalPages; // 추가: 전체 페이지 수
    private double progress;

    // 생성자
    public BookModel(String title, String author, String startDate, int totalPages) {
        this.title = title;
        this.author = author;
        this.startDate = startDate;
        this.lastReadDate = startDate;
        this.pagesRead = 0;
        this.totalPages = totalPages;
        this.progress = pagesRead/(float)totalPages*100;
    }
    // Getter 및 Setter 메서드들
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(String lastReadDate) {
        this.lastReadDate = lastReadDate;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

}
