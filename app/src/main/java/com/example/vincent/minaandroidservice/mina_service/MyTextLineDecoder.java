package com.example.vincent.minaandroidservice.mina_service;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service
 * @class describe
 * @date 2018/3/29 10:15
 */
public class MyTextLineDecoder implements ProtocolDecoder {

    @Override
    public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
            throws Exception {
        int startPosition = in.position();
        while (in.hasRemaining()) {
            byte b = in.get();
            if (b == '\n') {
                int currentPositoin = in.position();
                int limit = in.limit();
                in.position(startPosition);
                in.limit(currentPositoin);
                IoBuffer buf = in.slice();
                byte [] dest = new byte[buf.limit()];
                buf.get(dest);
                String str = new String(dest);
                out.write(str);
                in.position(currentPositoin);
                in.limit(limit);
            }
        }
    }

    @Override
    public void dispose(IoSession arg0) throws Exception {

    }

    @Override
    public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
            throws Exception {

    }

}