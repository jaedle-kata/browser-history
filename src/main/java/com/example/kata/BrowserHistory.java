package com.example.kata;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

  private static final int SIZE_LIMIT = 5;
  private List<String> urls;

  public BrowserHistory() {
    urls = new ArrayList<>();
  }

  public int size() {
    return urls.size();
  }

  public List<String> findAll() {
    return urls;
  }

  public void add(String url) {
    removeIfInHistory(url);
    dropLastElementIfFull();

    this.urls.add(0, url);
  }

  private void dropLastElementIfFull() {
    if(isFull()) {
      deleteLastElement();
    }
  }

  private void removeIfInHistory(String url) {
    if(isInHistory(url)) {
      remove(url);
    }
  }

  private boolean isFull() {
    return size() >= SIZE_LIMIT;
  }

  private void remove(String url) {
    urls.remove(url);
  }

  private boolean isInHistory(String url) {
    return this.urls.contains(url);
  }

  private void deleteLastElement() {
    this.urls.remove(4);
  }
}
