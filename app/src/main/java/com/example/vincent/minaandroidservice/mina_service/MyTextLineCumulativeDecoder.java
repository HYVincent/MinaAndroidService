package com.example.vincent.minaandroidservice.mina_service;

import android.util.Log;

import com.example.vincent.minaandroidservice.util.IoBufferTOString;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service
 * @class describe
 * @date 2018/3/29 10:14
 */
public class MyTextLineCumulativeDecoder extends CumulativeProtocolDecoder {

    private static final String TAG = MyTextLineCumulativeDecoder.class.getSimpleName();

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in,
                               ProtocolDecoderOutput out) throws Exception {
        //TODO  这里处理数据
       /* int startPosition = in.position();
        String test = IoBufferTOString.ioBufferToString1(in);
        Log.d(TAG, "doDecode: "+test);
        in.position(startPosition);*/


//        int sumlen = 4+1;//总长 = 包头+包体
        int sumlen = 3;//总长 = 包头+包体
        byte[] packArr = new byte[sumlen];
        in.get(packArr, 0 , sumlen);

     /*   IoBuffer buffer = IoBuffer.allocate(sumlen);
        buffer.put(packArr);
        buffer.flip();
        out.write(buffer);
        buffer.free();*/




        return false;
    }

}
