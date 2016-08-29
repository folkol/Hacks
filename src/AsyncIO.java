import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.nio.channels.SelectionKey.OP_CONNECT;
import static java.nio.channels.SelectionKey.OP_READ;
import static java.nio.channels.SelectionKey.OP_WRITE;

public class AsyncIO
{
    static class Request
    {
        ByteBuffer bb = ByteBuffer.allocate(1000);
        CharBuffer cb = CharBuffer.allocate(1000);
        private int i;

        public Request(int i)
        {
            this.i = i;
        }
    }

    private static final int N = 10;

    public static void main(String[] args) throws IOException
    {
        InetSocketAddress localhost = new InetSocketAddress("localhost", 1234);

        HttpServer httpServer = HttpServer.create(localhost, 100);
        httpServer.createContext("/", httpExchange -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Handling request");
            for (Map.Entry<String, List<String>> e : httpExchange.getRequestHeaders().entrySet()) {
                System.out.printf("%s: ", e.getKey());
                System.out.println(e.getValue());
            }
            System.out.println(new Scanner(httpExchange.getRequestBody()).useDelimiter("\\A").next());
            httpExchange.close();
        });
        System.out.println("Starting server.");
        httpServer.start();

        Selector selector = Selector.open();
        for (int i = 0; i < N; i++) {
            Request request = new Request(i);
            request.bb.put("HTTP/1.1 / GET\r\nHost: localhost\r\nContent-Length: 0\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            request.bb.flip();
            SocketChannel sc = SocketChannel.open(localhost);
            sc.configureBlocking(false);
            sc.register(selector, OP_CONNECT | OP_READ | OP_WRITE, request);
        }

        while (selector.keys().size() > 0) {
            System.out.println("Selecting...");
            int select = selector.select(1);
            System.out.printf("Selected %d channels.%n", select);
            for (SelectionKey key : selector.selectedKeys()) {
                Request attachment = (Request) key.attachment();
                SocketChannel channel = (SocketChannel) key.channel();
                System.out.println("Processing request " + attachment.i);
                SocketChannel sc = channel.socket().getChannel();
                if (key.isWritable()) {
                    System.out.println("Writable!");
                    sc.write(attachment.bb);
                }
                if (key.isReadable()) {
                    while (sc.read(attachment.bb) != -1)
                        ;
                    attachment.bb.flip();

                    System.out.println("Readable!");
                }
//                key.cancel();
            }
            selector.selectedKeys().clear();
        }
        selector.close();

        System.out.println("Stopping server.");
        httpServer.stop(0);
        System.out.println("Server stopped. Bye!");
    }
}
