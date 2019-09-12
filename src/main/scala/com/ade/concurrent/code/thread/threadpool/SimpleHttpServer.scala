package com.ade.concurrent.code.thread.threadpool

import java.io._
import java.net.{ServerSocket, Socket}

/**
  * @author: shudj
  * @time: 2019/9/12 11:31
  * @description:
  */
object SimpleHttpServer {

    var basePath: String = null
    var serverSocket: ServerSocket = null
    var port: Int = 8080
    private val threadPool = new DefaultThreadPool[HttpRequestHandler](1)
    def setPort(port: Int): Unit = {
        if (port > 0) {
            SimpleHttpServer.port = port
        }
    }

    def setBasePath(basePath: String): Unit = {
        if (null != basePath && new File(basePath).exists() && new File(basePath).isDirectory) {
            SimpleHttpServer.basePath = basePath
        }
    }

    // 启动SimpleHttpServer
    @throws[Exception] def start(): Unit = {
        serverSocket = new ServerSocket(port)
        var socket: Socket = null
        while ((socket = serverSocket.accept()) != null) {
            // 接收一个客户端Socket，生成一个HTTPRequestHandler,放入线程池执行
            threadPool.excute(new HttpRequestHandler(socket))
        }
        serverSocket.close()
    }

    class HttpRequestHandler extends Runnable {
        private var socket: Socket = null
        def this(socket: Socket) {
            this
            this.socket = socket
        }
        override def run(): Unit = {

            var line: String = null
            var br: BufferedReader = null
            var reader: BufferedReader = null
            var out: PrintWriter = null
            var in: InputStream = null

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream))
                var header: String = reader.readLine()
                // 由相对路径算出绝对路径
                val filePath: String = basePath + header.split("")(1)
                out = new PrintWriter(socket.getOutputStream)
                // 如果请求资源的后缀为jpg或者ico，则读取资源并输出
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath)
                    val baos: ByteArrayOutputStream = new ByteArrayOutputStream()
                    var i: Int = 0
                    while ((i = in.read()) != -1) {
                        baos.write(i)
                    }

                    val array = baos.toByteArray
                    out.println("HTTP/1.1 200 OK")
                    out.println("Server: Molly")
                    out.println("Content-Type: image/jpeg")
                    out.println("Content-Length: " + array.length)
                    out.println("")
                    socket.getOutputStream.write(array, 0, array.length)
                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))
                    out = new PrintWriter(socket.getOutputStream)
                    out.println("HTTP/1.1 200 OK")
                    out.println("Server: Molly")
                    out.println("Content-Type: text/html; charset=UTF-8")
                    out.println("")
                    while ((line = br.readLine()) != null) {
                        out.println(line)
                    }
                }
                out.flush()
            } catch {
                case ex: Exception => {
                    out.println("HTTP/1.1 500")
                    out.println("")
                    out.flush()
                }
            } finally {
                close(br, in, reader, out, socket)
            }
        }

        def close(closeables: Closeable*): Unit = {
            if (null != closeables) {
                closeables.foreach(closeable => {
                    closeable.close()
                })
            }
        }
    }
}
