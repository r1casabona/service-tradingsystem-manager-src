package br.com.mrxfocus.tradingsystemmanager.service.api.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author Rafael Casabona
 */
@Component
public class TcpClientConfig {

    /**
     * defines the time limit that the api will wait before giving a timeout
     */
//    @Value("${connection.timeout}")
    private static int connectionTimeout = 5000;

    /**
     * sets the time limit for reading that the api will wait before giving a timeout
     */
//    @Value("${connection.timeout.reading}")
    private static int connectionTimeoutReading = 5000;

    /**
     * sets the time limit for writing that the api will wait before giving a timeout
     */
//    @Value("${connection.timeout.writing}")
    private static int connectionTimeoutWriting = 5000;

    public static TcpClient getTcpClient() {
        return TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(connectionTimeoutReading, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(connectionTimeoutWriting, TimeUnit.MILLISECONDS));
                });
    }
}
