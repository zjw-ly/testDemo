package com.example.demo.protocol;

import com.example.demo.protocol.serialize.HessionSerialize;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author fuxi@cainiao.com
 * @date 2020/6/4
 **/

public class RpcEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] data = HessionSerialize.serialize(o);
        assert data != null;
        byteBuf.writeInt(data.length);
        byteBuf.writeBytes(data);
    }
}
