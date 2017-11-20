package com.mockito.tutorial.tutorialspoint;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PortfolioTester {

    private static final double EXPECTED_MARKET_VALUE = 100500.0;
    Portfolio portfolio;
    StockService stockService;

    @Before
    public void setUp() {
        //Create a portfolio object which is to be tested
        portfolio = new Portfolio();

        //Create the mock object of stock service
        stockService = mock(StockService.class);

        //set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue() {
        // arrange

        //Creates a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stocks);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        // act
        double marketValue = portfolio.getMarketValue();
        // verify
        assertEquals("Market value should be equal to " + EXPECTED_MARKET_VALUE, EXPECTED_MARKET_VALUE, marketValue, 0.01);
        verify(stockService, times(2)).getPrice(any(Stock.class));
    }
}