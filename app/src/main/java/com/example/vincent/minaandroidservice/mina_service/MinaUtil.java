package com.example.vincent.minaandroidservice.mina_service;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service
 * @class describe
 * @date 2018/3/29 10:08
 */
public class MinaUtil {

    private static NioSocketAcceptor acceptor =null;

    /**
     * start mina Service
     */
    public static boolean startMina(int port){
        boolean isOk;
        try {
            //1.
            acceptor = new NioSocketAcceptor();
            //2.网络管理和消息处理的分割开来； MyServerHandler()专门处理消息分发和会话管理
            acceptor.setHandler(new MyServerHandler());
            //3.拦截器，责任链设计模式。所有收发的消息全部要经过拦截器过滤之后，消息才可以收发；
            //网络上传输是字节，拦截器做对象的转换工作；
            //ProtocolCodecFilter 二进制数据和对象进行转化；MyTextLineFactory()内置的，对传输数据进行加解码
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyTextLineFactory()));
            acceptor.getFilterChain().addLast("mycoder", new ProtocolCodecFilter(new ByteArrayCodecFactory()));
            //每隔5秒，检查客户端是否处于空闲狂态，检测客户端是否掉线
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
            //4.服务器端口启动起来，监听9898
            acceptor.setReuseAddress(true);
            acceptor.bind(new InetSocketAddress(port));
            isOk = true;
        } catch(IOException e){
            e.printStackTrace();
            isOk = false;
        }
        return isOk;
    }

    /**
     * 停止
     */
    public static void stopMina(){
        if(acceptor != null){
            acceptor.unbind();
        }
    }

}
