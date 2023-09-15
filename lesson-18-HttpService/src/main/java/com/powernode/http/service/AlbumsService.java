package com.powernode.http.service;

import com.powernode.http.model.Albums;
import com.powernode.http.record.AlbumsRecord;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "https://jsonplaceholder.typicode.com")
public interface AlbumsService {

    @HttpExchange(method = "GET", url = "/albums/{id}")
    Albums getById(@PathVariable Integer id);


    @HttpExchange(method = "GET", url = "/albums/{id}", contentType = MediaType.APPLICATION_JSON_VALUE)
    AlbumsRecord getByIdReturnRecord(@PathVariable Integer id);
}
