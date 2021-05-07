package com.binance.api.examples;

import com.binance.api.client.api.sync.BinanceApiSwapRestClient;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceSwapApiClientFactory;

import java.util.List;

public class SwapEndpointExample {

    public static void main(String[] args) {
//        BinanceSwapApiClientFactory factory = (BinanceSwapApiClientFactory) BinanceAbstractFactory.createFactory("YOUR_API_KEY", "YOUR_SECRET", BinanceEngineType.SWAP);
        BinanceSwapApiClientFactory factory = BinanceAbstractFactory.createSwapFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiSwapRestClient swapClient = factory.newRestClient();
        List<Pool> pools = swapClient.listAllSwapPools();
        for (Pool pool : pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        System.out.println(swapQuote);
        SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        List<SwapHistory> swapHistory = swapClient.getSwapHistory();
        System.out.println(swapHistory);
    }
}
