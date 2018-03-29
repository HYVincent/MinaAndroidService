package com.example.vincent.minaandroidservice.util;

import org.apache.mina.core.buffer.IoBuffer;

import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.util
 * @class describe
 * @date 2018/3/29 14:11
 */
public class IoBufferTOString {

    public static String ioBufferToString1(IoBuffer iobuffer){
        System.out.println("message = " + iobuffer + iobuffer.limit());
        iobuffer.flip();    //调换buffer当前位置，并将当前位置设置成0
        byte[] b = new byte[iobuffer.limit()];
        iobuffer.get(b);
        //此处用stringbuffer是因为　String类是字符串常量，是不可更改的常量。而StringBuffer是字符串变量，它的对象是可以扩充和修改的。
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < b.length; i++){
            System.out.println("====" + b[i]);
            stringBuffer.append((char) b[i]); //可以根据需要自己改变类型
            System.out.println(b[i] +"---------" +i);
        }
        return stringBuffer.toString();
    }


  /*  public static void main(String[] args) throws CharacterCodingException {
        IoBuffer iobuffer = IoBuffer.allocate(8);
        iobuffer.order(ByteOrder.LITTLE_ENDIAN);
//        iobuffer.setAutoExpand(true);
        iobuffer.putChar('z');

        String str = ioBufferToString1(iobuffer);
        System.out.println(str);

    }*/

    public static String byteToString(byte [] b)
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            stringBuffer.append((char) b [i]);
        }
        return stringBuffer.toString();
    }


    public static IoBuffer stringToIoBuffer(String str)
    {

        byte bt[] = str.getBytes();

        IoBuffer ioBuffer = IoBuffer.allocate(bt.length);
        ioBuffer.put(bt, 0, bt.length);
        ioBuffer.flip();
        return ioBuffer;
    }

    public static IoBuffer byteToIoBuffer(byte [] bt,int length)
    {

        IoBuffer ioBuffer = IoBuffer.allocate(length);
        ioBuffer.put(bt, 0, length);
        ioBuffer.flip();
        return ioBuffer;
    }

    public static byte [] ioBufferToByte(Object message)
    {
        if (!(message instanceof IoBuffer))
        {
            return null;
        }
        IoBuffer ioBuffer = (IoBuffer)message;
        byte[] b = new byte[ioBuffer.limit()];
        ioBuffer.get(b);
        return b;
    }

    public static String ioBufferToString(Object message)
    {
        if (!(message instanceof IoBuffer))
        {
            return "";
        }
        IoBuffer ioBuffer = (IoBuffer) message;
        byte[] b = new byte [ioBuffer.limit()];
        ioBuffer.get(b);
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < b.length; i++)
        {

            stringBuffer.append((char) b [i]);
        }
        return stringBuffer.toString();
    }

}
