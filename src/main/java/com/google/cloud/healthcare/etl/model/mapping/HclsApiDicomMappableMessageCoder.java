package com.google.cloud.healthcare.etl.model.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;
import org.apache.beam.sdk.coders.CustomCoder;
import org.apache.beam.sdk.coders.NullableCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;

/** Coder for {@link HclsApiDicomMappableMessage}. */
public class HclsApiDicomMappableMessageCoder extends CustomCoder<HclsApiDicomMappableMessage> {
    private static final NullableCoder<String> STRING_CODER = NullableCoder.of((Coder)StringUtf8Coder.of());

    public static HclsApiDicomMappableMessageCoder of() {
        return new HclsApiDicomMappableMessageCoder();
    }

    public void encode(HclsApiDicomMappableMessage value, OutputStream outStream) throws CoderException, IOException {
        STRING_CODER.encode(value.getData(), outStream);
    }

    public HclsApiDicomMappableMessage decode(InputStream inStream) throws CoderException, IOException {
        String data = (String)STRING_CODER.decode(inStream);
        return new HclsApiDicomMappableMessage(data);
    }
}
