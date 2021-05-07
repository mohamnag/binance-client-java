package com.binance.api.client.constant;

import com.binance.api.client.domain.market.Candlestick;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @see BinanceApiConstants
 */
public class BinanceApiConstantsTest {

    private static String candlestickRaw;
    private static Candlestick candlestick;
    private static ToStringStyle DEFAULT_TO_STRING_BUILDER_STYLE;

    @BeforeClass
    public static void setUpClass() {

        DEFAULT_TO_STRING_BUILDER_STYLE = BinanceApiConstants.TO_STRING_BUILDER_STYLE;

        candlestickRaw = "[\n"
            + "    1499040000000,\n"
            + "        \"0.01634790\",\n"
            + "        \"0.80000000\",\n"
            + "        \"0.01575800\",\n"
            + "        \"0.01577100\",\n"
            + "        \"148976.11427815\",\n"
            + "        1499644799999,\n"
            + "        \"2434.19055334\",\n"
            + "        308,\n"
            + "        \"1756.87402397\",\n"
            + "        \"28.46694368\",\n"
            + "        \"17928899.62484339\"\n"
            + "        ]";
        ObjectMapper mapper = new ObjectMapper();

        try {
            candlestick = mapper.readValue(candlestickRaw, Candlestick.class);
        } catch (IOException e) {
            fail();
        }
    }

    @AfterClass
    public static void tearDownClass() {
        BinanceApiConstants.TO_STRING_BUILDER_STYLE = DEFAULT_TO_STRING_BUILDER_STYLE;
    }

    @Ignore("to be reviewed and either removed or improved")
    @Test
    public void testToStringBuilderStyleChange() {
        String binanceApiDefaultStyle = "Candlestick[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]";
        assertEquals(binanceApiDefaultStyle, candlestick.toString());

        BinanceApiConstants.TO_STRING_BUILDER_STYLE = ToStringStyle.JSON_STYLE;
        String jsonStyle = "{\"openTime\":1499040000000,\"open\":\"0.01634790\",\"high\":\"0.80000000\",\"low\":\"0.01575800\",\"close\":\"0.01577100\",\"volume\":\"148976.11427815\",\"closeTime\":1499644799999,\"quoteAssetVolume\":\"2434.19055334\",\"numberOfTrades\":308,\"takerBuyBaseAssetVolume\":\"1756.87402397\",\"takerBuyQuoteAssetVolume\":\"28.46694368\"}";
        assertEquals(candlestick.toString(), jsonStyle);

        BinanceApiConstants.TO_STRING_BUILDER_STYLE = ToStringStyle.NO_CLASS_NAME_STYLE;
        String noClassNameStyle = "[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]";
        assertEquals(candlestick.toString(), noClassNameStyle);

        BinanceApiConstants.TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
        String shortPrefixStyle = "Candlestick[openTime=1499040000000,open=0.01634790,high=0.80000000,low=0.01575800,close=0.01577100,volume=148976.11427815,closeTime=1499644799999,quoteAssetVolume=2434.19055334,numberOfTrades=308,takerBuyBaseAssetVolume=1756.87402397,takerBuyQuoteAssetVolume=28.46694368]";
        assertEquals(candlestick.toString(), shortPrefixStyle);

        BinanceApiConstants.TO_STRING_BUILDER_STYLE = ToStringStyle.SIMPLE_STYLE;
        String simpleStyle = "1499040000000,0.01634790,0.80000000,0.01575800,0.01577100,148976.11427815,1499644799999,2434.19055334,308,1756.87402397,28.46694368";
        assertEquals(candlestick.toString(), simpleStyle);
    }
}
