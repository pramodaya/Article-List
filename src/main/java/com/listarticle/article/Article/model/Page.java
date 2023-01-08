package com.listarticle.article.Article.model;

public class Page {
    private int size;
    private int pageNumber;

    public Page(int size, int pageNumber) {
        this.size = size;
        this.pageNumber = pageNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Page{" +
                "size=" + size +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
