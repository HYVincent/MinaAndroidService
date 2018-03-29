package com.example.vincent.minaandroidservice.mina_service;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.mina_service
 * @class describe
 * @date 2018/3/29 10:14
 */
public class MyTextLineFactory implements ProtocolCodecFactory {

    private MyTextLineDecoder mDecoder;

    private MyTextLineCumulativeDecoder mCumulativeDecoder;

    private MyTextLineEncoder mEncoder;

    public MyTextLineFactory () {
        mDecoder = new MyTextLineDecoder();
        mEncoder = new MyTextLineEncoder();
        mCumulativeDecoder = new MyTextLineCumulativeDecoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
        return mCumulativeDecoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
        return mEncoder;
    }

}
