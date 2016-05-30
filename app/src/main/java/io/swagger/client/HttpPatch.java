package io.swagger.client;

import cz.msebera.android.httpclient.client.methods.HttpPost;

public class HttpPatch extends HttpPost {
    public static final String METHOD_PATCH = "PATCH";

    public HttpPatch(final String url) {
        super(url);
    }

    @Override
    public String getMethod() {
        return METHOD_PATCH;
    }
}