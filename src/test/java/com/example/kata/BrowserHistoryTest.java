package com.example.kata;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class BrowserHistoryTest {

  private static final String URL = "https://www.google.de";
  private static final String URL_1 = "https://www.google.de";
  private static final String URL_2 = "https://www.denic.de";
  private static final String URL_3 = "https://www.amazon.de";
  private static final String URL_4 = "https://www.whoknows.de";
  private static final String URL_5 = "https://www.stackoverflow.com";
  private static final String URL_6 = "https://www.lanarena.de";

  @Test
  public void createdHistoryIsEmpty() {
    BrowserHistory empty = new BrowserHistory();

    assertEquals(0, empty.size());
    assertEquals(Collections.emptyList(), empty.findAll());
  }

  @Test
  public void canAddMultipleEntries() {
    BrowserHistory history = createBrowserHistory(Arrays.asList(URL_1, URL_2));

    assertEquals(2, history.size());
    assertEquals(Arrays.asList(URL_2, URL_1), history.findAll());
  }

  @Test
  public void dropsLeastRecentElementIfExceedsSize() {
    BrowserHistory history = createBrowserHistory(Arrays.asList(URL_1, URL_2, URL_3, URL_4, URL_5));

    history.add(URL_6);

    assertEquals(5, history.size());
    assertEquals(Arrays.asList(URL_6, URL_5, URL_4, URL_3, URL_2), history.findAll());
  }

  private BrowserHistory createBrowserHistory(List<String> urls) {
    BrowserHistory history = new BrowserHistory();
    urls.forEach(url -> history.add(url));
    return history;
  }


  @Test
  public void urlCanNotBeAddedTwice() {
    BrowserHistory history = createBrowserHistory(Arrays.asList(URL_1));

    history.add(URL_1);

    assertEquals(1, history.size());
    assertEquals(Arrays.asList(URL_1), history.findAll());
  }

  @Test
  public void ifUrlIsRevistedItIsMostRecentUrl() {
    BrowserHistory history = createBrowserHistory(Arrays.asList(URL_1, URL_2, URL_3, URL_4));

    history.add(URL_2);

    assertEquals(4, history.size());
    assertEquals(Arrays.asList(URL_2, URL_4, URL_3, URL_1), history.findAll());
  }

  @Test
  public void doesNotDropLastEntryIfUrlIsRefreshed() {
    BrowserHistory history = createBrowserHistory(Arrays.asList(URL_1, URL_2, URL_3, URL_4, URL_5));

    history.add(URL_3);

    assertEquals(5, history.size());
    assertEquals(Arrays.asList(URL_3, URL_5, URL_4, URL_2, URL_1), history.findAll());

  }
}
