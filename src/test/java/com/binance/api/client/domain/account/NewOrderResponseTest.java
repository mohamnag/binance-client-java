package com.binance.api.client.domain.account;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @see NewOrderResponse
 */
public class NewOrderResponseTest {

  private NewOrderResponse newOrderResponse;
  private Trade trade;

  @Before
  public void setUp() {
    newOrderResponse = new NewOrderResponse();
    trade = new Trade();
    trade.setId(123L);
  }

  @Ignore("to be reviewed and either removed or improved")
  @Test
  public void shouldHandleToStringWithNullFills() {
    assertThat(newOrderResponse.toString(), containsString(",fills="));
  }

  @Ignore("to be reviewed and either removed or improved")
  @Test
  public void shouldHandleToStringWithNoFills() {
    newOrderResponse.setFills(Collections.emptyList());
    assertThat(newOrderResponse.toString(), containsString(",fills="));
  }

  @Ignore("to be reviewed and either removed or improved")
  @Test
  public void shouldHandleToStringWithFills() {
    newOrderResponse.setFills(trades(trade));
    assertThat(newOrderResponse.toString(), containsString(",fills=Trade[id=123,"));
  }

  private static List<Trade> trades(final Trade... trades) {
    return Arrays.asList(trades);
  }
}
