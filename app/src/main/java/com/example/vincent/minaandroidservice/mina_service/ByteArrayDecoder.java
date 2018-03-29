package com.example.vincent.minaandroidservice.mina_service;

import android.util.Log;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service.test
 * @class describe
 * @date 2018/3/29 13:54
 */
public class ByteArrayDecoder extends CumulativeProtocolDecoder {

    private static final String TAG = ByteArrayDecoder.class.getSimpleName();

    @Override
    public boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
            throws Exception {
        Log.d(TAG, "doDecode: "+in);
        return false;//处理成功，让父类进行接收下个包
    }

}