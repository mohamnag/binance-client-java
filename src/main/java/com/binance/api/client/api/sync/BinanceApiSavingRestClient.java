package com.binance.api.client.api.sync;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.domain.account.Liquidity;
import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;

import java.util.List;

import retrofit2.http.Query;

public interface BinanceApiSavingRestClient {

    List<RedemptionRecord> getRedemptionRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp);

    List<PurchaseRecord> getPurchaseRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp
    );

    List<InterestHistory> getInterestHistory (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp
    );

}
