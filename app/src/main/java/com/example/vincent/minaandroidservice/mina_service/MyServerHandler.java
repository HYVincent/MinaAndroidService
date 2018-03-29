package com.example.vincent.minaandroidservice.mina_service;

import android.util.Log;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service
 * @class describe
 * @date 2018/3/29 10:09
 */
public class MyServerHandler extends IoHandlerAdapter {

    private static final String TAG = MyServerHandler.class.getSimpleName();

    /**
     * 当 I/O 处理器的实现或是 Apache MINA 中有异常抛出的时候，此方法被调用
     * @param session
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        Log.e(TAG, "exceptionCaught: "+cause.getMessage() );
        Log.d(TAG, "exceptionCaught: "+session);
    }

    /**
     * messageReceived 接收到新消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Log.d(TAG, "messageReceived: 收到消息-->"+String.valueOf(message));

    }

    /**
     * 当消息被成功发送出去的时候，此方法被调用。
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        Log.d(TAG, "messageSent: 消息发送成功-->"+String.valueOf(message)+" "+session);
    }

    /**
     * 当连接被关闭的时候，此方法被调用。
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        Log.d(TAG, "sessionClosed: 连接"+"关闭"+session);
    }

    /**
     * 当有新的连接的时候调用这个方法
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        Log.d(TAG, "sessionCreated: "+session);
        session.getRemoteAddress();
    }

    /**
     * /客户端进入空闲状态,检测 客户端 是否掉线
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception{
        Log.d(TAG, "sessionIdle: "+session+status);

    }

    /**
     * 当有新的连接打开的时候，该方法被调用。该方法在 sessionCreated之后被调用。
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        Log.d(TAG, "sessionOpened: "+session);
    }


}
