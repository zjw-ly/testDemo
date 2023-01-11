package com.example.demo.protocol;

import com.example.demo.protocol.serialize.HessionSerialize;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * rpc解码器
 *
 * @author zaochun.zjw
 * @date 2023/1/10
 */
public class RpcDecoder extends ByteToMessageDecoder {

    public RpcDecoder() {
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        Object obj = HessionSerialize.deserialize(data);
        assert obj != null;
        out.add(obj);
    }
}
