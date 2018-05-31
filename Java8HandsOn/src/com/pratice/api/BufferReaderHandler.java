package com.pratice.api;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderHandler {
	String processFile(BufferedReader br) throws IOException;
}
