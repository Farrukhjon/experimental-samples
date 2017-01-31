package org.farrukh.experiments.spring.batch.etl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

import org.springframework.batch.item.file.BufferedReaderFactory;
import org.springframework.core.io.Resource;

public class GZBufferedReader implements BufferedReaderFactory {

    @Override
    public BufferedReader create(Resource resource, String encoding) throws UnsupportedEncodingException, IOException {
        return new BufferedReader(new InputStreamReader(new GZIPInputStream(resource.getInputStream()), encoding));
    }

}
