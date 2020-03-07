package com.sapient.test.utils;

import org.eclipse.jetty.client.api.Response;

import java.util.Map;

public interface RestUtil {
    <Req, Res> Res getAsync(Req req, Map<String, String> requestParams, String url, Response.CompleteListener responseListner);
    <Res> Res get(String url, Class<Res> resClass);
}
