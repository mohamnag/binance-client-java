# Binance Client
[![pipeline status][Pipelines Shield]][Pipelines Link]
[![snapshot artifacts][Snapshot Shield]][Snapshot Link]
[![release artifacts][Release Shield]][Release Link]

This is a lightweight Java library for interacting with the [Binance API][Binance API Docs], striving to provide complete API coverage, and supporting synchronous and asynchronous requests, as well as event streaming using WebSockets.

## Features
* Support for synchronous and asynchronous REST requests to all General, Market Data, Account endpoints, and User stream endpoints.
* Support for User Data, Trade, Kline, and Depth event streaming using Binance WebSocket API.

## Installation
Please take the latest versions from badges on the top.

### Snapshots
To use snapshots, you need to include OSS Sonatype Snapshot repository and add artifact as follows:

```groovy
repositories {
  mavenCentral()
  maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}

dependencies {
  implementation 'com.mohamnag.binance-client:binance-client-java:<version>'
}
```

### Releases
Once there will be a release, it will be published to maven central.

```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation 'com.mohamnag.binance-client:binance-client-java:1.0.0'
}
```

## Usage
To understand the functionality of Binance API please refer to its docs [here][Binance API Docs].

For concrete examples how to use this library see the package `com.binance.api.examples` under tests [here](src/test/java/com/binance/api/examples). In general the main entry point would be the class `com.binance.api.client.factory.BinanceAbstractFactory`.

Providing an API key and secret is only necessary if you are going to use secured endpoints.

### WebSocket API

User needs to be aware that REST symbols which are `upper case` differ from WebSocket symbols which must be `lower case`. In scenario of subscription with upper case styled symbol, server will return no error and subscribe to given channel - however, no events will be pushed.

#### Handling web socket errors

Each of the methods on `BinanceApiWebSocketClient`, which opens a new web socket, takes a `BinanceApiCallback`, which is called for each event received from the Binance servers.

The `BinanceApiCallback` interface also has a `onFailure(Throwable)` method, which, optionally, can be implemented to receive notifications if the web-socket fails, e.g. disconnection.

```java
client.onAggTradeEvent(symbol.toLowerCase(), new BinanceApiCallback<AggTradeEvent>() {
    @Override
    public void onResponse(final AggTradeEvent response) {
        System.out.println(response);
    }

    @Override
    public void onFailure(final Throwable cause) {
        System.err.println("Web socket failed");
        cause.printStackTrace(System.err);
    }
});
```

#### Closing web sockets

Each of the methods on `BinanceApiWebSocketClient`, which opens a new web socket, also returns a `Closeable`. This `Closeable` can be used to close the underlying web socket and free any associated resources, e.g.

```java
Closable ws = client.onAggTradeEvent("ethbtc", someCallback);
// some time later...
ws.close();
```

## Contribution
As any open source project, this library is the result of a lot of time invested by many people which do it as a hobby or in their free time. If a feature is missing, or you discover a problem don't hesitate to report, but also consider contributing yourself too.

  [Binance API Docs]: https://github.com/binance/binance-spot-api-docs
  [Pipelines Shield]: https://gitlab.com/mohamnag/binance-client-java/badges/master/pipeline.svg
  [Pipelines Link]: https://gitlab.com/mohamnag/binance-client-java/-/pipelines
  [Snapshot Shield]: https://img.shields.io/nexus/s/com.mohamnag.binance-client/binance-client-java?label=maven&server=https%3A%2F%2Foss.sonatype.org
  [Snapshot Link]: https://oss.sonatype.org/#nexus-search;quick~com.mohamnag.binance-client
  [Release Shield]: https://img.shields.io/nexus/r/com.mohamnag.binance-client/binance-client-java?label=maven&server=https%3A%2F%2Foss.sonatype.org
  [Release Link]: https://search.maven.org/search?q=com.mohamnag.binance-client
