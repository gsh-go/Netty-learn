package com.gsh.netty;

import java.io.IOException;

/**
 * @Author: gsh
 * @Date: Created in 2018/9/28 15:44
 * @Description:
 */
public class Server {

    public static void main(String[] args) {
        try {
            TCPReactor reactor = new TCPReactor(1234);
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}




